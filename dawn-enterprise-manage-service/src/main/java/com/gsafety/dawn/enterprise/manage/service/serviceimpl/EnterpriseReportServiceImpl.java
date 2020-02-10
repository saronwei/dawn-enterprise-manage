package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.common.exception.BusinessException;
import com.gsafety.dawn.enterprise.common.exception.ErrorCode;
import com.gsafety.dawn.enterprise.common.util.StringUtil;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportQueryInfo;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseReportService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.EnterpriseReportMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseReportRepository;
import com.gsafety.java.common.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnterpriseReportServiceImpl implements EnterpriseReportService {
    @Autowired
    private EnterpriseReportMapper enterpriseReportMapper;
    @Autowired
    private EnterpriseReportRepository enterpriseReportRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EnterpriseReportModel saveEnterpriseReport(EnterpriseReportModel enterpriseReportModel) {
        if (StringUtil.isEmpty(enterpriseReportModel.getEnterpriseName())) {
            throw new BusinessException(ErrorCode.PARAM_NOT_COMPLETE);
        }
        List<EnterpriseReportEntity> enterpriseReportEntities = enterpriseReportRepository
                .findByEnterpriseName(enterpriseReportModel.getEnterpriseName());
        if (!CollectionUtils.isEmpty(enterpriseReportEntities)) {
            enterpriseReportRepository.deleteAll(enterpriseReportEntities);
        }
        enterpriseReportModel.setReportId(StringUtil.genUUID());
        enterpriseReportModel.setReportTime(new Date());
        EnterpriseReportEntity enterpriseReportEntity = enterpriseReportMapper.modelToEntity(enterpriseReportModel);
        EnterpriseReportEntity enterpriseReportEntityCopy = enterpriseReportRepository.save(enterpriseReportEntity);
        return enterpriseReportMapper.entityToModel(enterpriseReportEntityCopy);
    }

    @Override
    public PageBean<EnterpriseReportModel> findByQueryInfo(EnterpriseReportQueryInfo queryInfo) {
        if (queryInfo == null) {
            return null;
        } else if (queryInfo.getCurrentPage() == null || queryInfo.getPageSize() == null) {
            // 查询所有
            List<EnterpriseReportEntity> allData = enterpriseReportRepository.findAll(createSpecification(queryInfo));
            PageBean<EnterpriseReportModel> pageBean = new PageBean<>();
            pageBean.setData(enterpriseReportMapper.entitiesToModels(allData));
            pageBean.setTotalCount(allData.size());
        } else {
            Pageable pageable = PageRequest.of(queryInfo.getCurrentPage() - 1, queryInfo.getPageSize());
            Page<EnterpriseReportEntity> pageData = enterpriseReportRepository.findAll(createSpecification(queryInfo), pageable);
            PageBean<EnterpriseReportModel> pageBean = new PageBean<>();
            pageBean.setCurrentPage(pageData.getNumber() + 1);
            pageBean.setPageSize(pageData.getSize());
            pageBean.setTotalPage(pageData.getTotalPages());
            pageBean.setData(enterpriseReportMapper.entitiesToModels(pageData.getContent()));
            pageBean.setTotalCount(pageData.getTotalElements());
            return pageBean;
        }

        return null;
    }

    private Specification<EnterpriseReportEntity> createSpecification(EnterpriseReportQueryInfo queryInfo) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtil.isNotEmpty(queryInfo.getEnterpriseName())) {
                predicates.add(cb.equal(root.get("name"), queryInfo.getEnterpriseName()));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
