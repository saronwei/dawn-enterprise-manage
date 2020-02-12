package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.common.exception.BusinessException;
import com.gsafety.dawn.enterprise.common.exception.ErrorCode;
import com.gsafety.dawn.enterprise.common.util.BeanUtil;
import com.gsafety.dawn.enterprise.common.util.SortUtil;
import com.gsafety.dawn.enterprise.common.util.StringUtil;
import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportModel;
import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportQueryInfo;
import com.gsafety.dawn.enterprise.manage.contract.service.CompanyReportService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.CompanyReportMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.CompanyMeasureEntity;
import com.gsafety.dawn.enterprise.manage.service.entity.CompanyReportEntity;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseInfoEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.CompanyMeasureRepository;
import com.gsafety.dawn.enterprise.manage.service.repository.CompanyReportRepository;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseInfoRepository;
import com.gsafety.java.common.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CompanyReportServiceImpl implements CompanyReportService {
    @Autowired
    private CompanyReportMapper companyReportMapper;
    @Autowired
    private CompanyReportRepository companyReportRepository;
    @Autowired
    private CompanyMeasureRepository companyMeasureRepository;
    @Autowired
    private EnterpriseInfoRepository enterpriseInfoRepository;

    @Override
    public CompanyReportModel findByCompanyId(String companyId) {
        return companyReportRepository.findByCompanyId(companyId)
                .stream()
                .findFirst()
                .map(item -> companyReportMapper.entityToModel(item))
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CompanyReportModel saveCompanyReport(CompanyReportModel companyReportModel) {
        if (companyReportModel == null) {
            return null;
        }
        if (StringUtil.isEmpty(companyReportModel.getCompanyId())) {
            throw new BusinessException(ErrorCode.PARAM_NOT_COMPLETE);
        }

        companyReportModel.setReportId(StringUtil.genUUID());
        Date date = new Date();
        companyReportModel.setCtime(date);
        companyReportModel.setMtime(date);
        companyReportModel.setReportDate(date);
        CompanyReportEntity companyReportEntity = companyReportMapper.modelToEntity(companyReportModel);
        CompanyReportEntity companyReportEntityCopy = companyReportRepository.save(companyReportEntity);
        // 解析并存储最新上报的防疫措施用于统计
        String companyId = companyReportModel.getCompanyId();
        companyMeasureRepository.deleteByCompanyId(companyId);
        if (StringUtil.isNotEmpty(companyReportModel.getMeasures())) {
            companyMeasureRepository.saveAll(getCompanyMeasureEntities(companyId, companyReportModel.getMeasures()));
        }

        return companyReportMapper.entityToModel(companyReportEntityCopy);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CompanyReportModel updateCompanyReport(CompanyReportModel companyReportModel) {
        CompanyReportEntity companyReportEntity = companyReportMapper.modelToEntity(companyReportModel);
        // 通过id查询对应的实体
        return companyReportRepository.findById(companyReportModel.getReportId())
                .map(item -> {
                    String sourceCompanyId = item.getCompanyId();
                    BeanUtil.copyPropertiesIgnoreNull(companyReportEntity, item);
                    // 更新日期等信息
                    Date date = new Date();
                    item.setReportDate(date);
                    item.setMtime(date);
                    // 以最新的防疫措施值为准
                    item.setMeasures(companyReportModel.getMeasures());
                    CompanyReportEntity companyReportEntityCopy = companyReportRepository.saveAndFlush(item);

                    // 处理防疫措施相关逻辑
                    companyMeasureRepository.deleteByCompanyId(sourceCompanyId);
                    if (StringUtil.isNotEmpty(companyReportModel.getCompanyId())
                            && !sourceCompanyId.equals(companyReportModel.getCompanyId())) {
                        // 如果要更新企业ID, 则删除新关联企业防疫措施
                        companyMeasureRepository.deleteByCompanyId(companyReportModel.getCompanyId());
                        EnterpriseInfoEntity enterpriseInfoEntity = enterpriseInfoRepository.findById(companyReportModel.getCompanyId()).orElse(null);
                        companyReportEntityCopy.setEnterpriseInfoEntity(enterpriseInfoEntity);
                    }
                    // 如果防疫措施有值, 则新增防疫措施关联数据
                    if (StringUtil.isNotEmpty(companyReportEntityCopy.getMeasures())) {
                        companyMeasureRepository.saveAll(getCompanyMeasureEntities(companyReportEntityCopy.getCompanyId(),
                                companyReportEntityCopy.getMeasures()));
                    }

                    return companyReportMapper.entityToModel(companyReportEntityCopy);
                })
                .orElseThrow(() -> new BusinessException(ErrorCode.DATA_NOT_EXIST));
    }

    @Override
    public PageBean<CompanyReportModel> findByQueryInfo(CompanyReportQueryInfo queryInfo) {
        if (queryInfo == null) {
            return null;
        } else if (queryInfo.getCurrentPage() == null || queryInfo.getPageSize() == null) {
            // 查询所有
            List<CompanyReportEntity> allData = companyReportRepository.findAll(createSpecification(queryInfo));
            PageBean<CompanyReportModel> pageBean = new PageBean<>();
            pageBean.setData(companyReportMapper.entitiesToModels(allData));
            pageBean.setTotalCount(allData.size());
            return pageBean;
        } else {
            Pageable pageable;
            if (CollectionUtils.isEmpty(queryInfo.getSorts())) {
                pageable = PageRequest.of(queryInfo.getCurrentPage() - 1, queryInfo.getPageSize());
            } else {
                Sort sort = SortUtil.createSort(queryInfo.getSorts());
                pageable = PageRequest.of(queryInfo.getCurrentPage() - 1, queryInfo.getPageSize(), sort);
            }

            Page<CompanyReportEntity> pageData = companyReportRepository.findAll(createSpecification(queryInfo), pageable);
            PageBean<CompanyReportModel> pageBean = new PageBean<>();
            pageBean.setCurrentPage(pageData.getNumber() + 1);
            pageBean.setPageSize(pageData.getSize());
            pageBean.setTotalPage(pageData.getTotalPages());
            pageBean.setData(companyReportMapper.entitiesToModels(pageData.getContent()));
            pageBean.setTotalCount(pageData.getTotalElements());
            return pageBean;
        }
    }

    private List<CompanyMeasureEntity> getCompanyMeasureEntities(String companyId, String measures) {
        if (StringUtil.isEmpty(measures)) {
            return Collections.emptyList();
        }
        String[] measureArr = measures.split(",");
        List<CompanyMeasureEntity> companyMeasureEntities = new ArrayList<>();
        for (String measure : measureArr) {
            CompanyMeasureEntity companyMeasureEntity = new CompanyMeasureEntity();
            companyMeasureEntity.setCompanyMeasureId(StringUtil.genUUID());
            companyMeasureEntity.setCompanyId(companyId);
            companyMeasureEntity.setMeasureId(measure);
            companyMeasureEntities.add(companyMeasureEntity);
        }
        return companyMeasureEntities;
    }

    private Specification<CompanyReportEntity> createSpecification(CompanyReportQueryInfo queryInfo) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            List<String> companyIds = queryInfo.getCompanyIds();
            if (!CollectionUtils.isEmpty(companyIds)) {
                predicates.add(root.get("companyId").in(companyIds));
            }

            if (StringUtil.isNotEmpty(queryInfo.getTypeOrAreaName())) {
                Join<CompanyReportEntity, EnterpriseInfoEntity> enterpriseJoin = root.join("enterpriseInfoEntity", JoinType.INNER);
                String likeCondition = "%" + queryInfo.getTypeOrAreaName() + "%";
                Predicate typeNameLike = cb.like(enterpriseJoin.get("typeName"), likeCondition);
                Predicate areaNameLike = cb.like(enterpriseJoin.get("areaName"), likeCondition);
                predicates.add(cb.or(typeNameLike, areaNameLike));
            }

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
