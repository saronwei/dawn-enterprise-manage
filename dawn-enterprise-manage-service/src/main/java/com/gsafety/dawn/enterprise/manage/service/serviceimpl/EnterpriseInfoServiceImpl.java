package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.common.util.ExcelUtil;
import com.gsafety.dawn.enterprise.common.util.StringUtil;
import com.gsafety.dawn.enterprise.manage.contract.model.*;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseInfoService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.EnterpriseInfoMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseInfoEntity;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseInfoRepository;
import com.gsafety.java.common.page.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 企业基本信息服务
 */
@Service
@Transactional
public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {
    // 日志
    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    @Autowired
    EnterpriseInfoMapper enterpriseInfoMapper;

    @Autowired
    EnterpriseInfoRepository enterpriseInfoRepository;

    /**
     * 按Id查询企业基本信息
     * @param id
     * @return
     */
    @Override
    public EnterpriseInfoModel getEnterpriseInfoById(String id) {
        if(StringUtil.isEmpty(id)) return null;
        return enterpriseInfoMapper.entityToModel(
                enterpriseInfoRepository.findById(id).get());
    }

    /**
     * 按租户Id查询企业基本信息
     * @param antId
     * @return
     */
    @Override
    public EnterpriseInfoModel getEnterpriseInfoByAntId(String antId) {
        if(StringUtil.isEmpty(antId)) return null;
        return enterpriseInfoMapper.entityToModel(
                enterpriseInfoRepository.findByTenAntId(antId));
    }

    /**
     * 企业基本信息按条件分页查询
     * @param queryInfo
     * @return
     */
    @Override
    public PageBean<EnterpriseInfoModel> getEnterpriseInfoModelByPage(EnterpriseInfoQueryInfo queryInfo) {
        if (queryInfo == null) {
            return null;
        } else if(queryInfo.getCurrentPage() == null || queryInfo.getPageSize() == null) {
            // 查询所有
            List<EnterpriseInfoEntity> allData = enterpriseInfoRepository.findAll(createSpecification(queryInfo));
            PageBean<EnterpriseInfoModel> pageBean = new PageBean<>();
            pageBean.setData(enterpriseInfoMapper.entitiesToModels(allData));
            pageBean.setTotalCount(allData.size());
            return pageBean;
        } else {
            Pageable pageable = PageRequest.of(queryInfo.getCurrentPage() - 1, queryInfo.getPageSize());
            Page<EnterpriseInfoEntity> pageData = enterpriseInfoRepository.findAll(createSpecification(queryInfo), pageable);
            PageBean<EnterpriseInfoModel> pageBean = new PageBean<>();
            pageBean.setCurrentPage(pageData.getNumber() + 1);
            pageBean.setPageSize(pageData.getSize());
            pageBean.setTotalPage(pageData.getTotalPages());
            pageBean.setData(enterpriseInfoMapper.entitiesToModels(pageData.getContent()));
            pageBean.setTotalCount(pageData.getTotalElements());
            return pageBean;
        }
    }

    /**
     * 新增/修改企业基本信息
     * @param model
     * @return
     */
    @Override
    public EnterpriseInfoModel saveEnterpriseInfoModel(EnterpriseInfoModel model) {
        EnterpriseInfoEntity enterpriseInfoEntity = new EnterpriseInfoEntity();
        if(model != null && StringUtil.isEmpty(model.getId())){
            model.setId(UUID.randomUUID().toString());
            enterpriseInfoEntity = enterpriseInfoMapper.modelToEntity(model);
        } else {
            enterpriseInfoEntity = enterpriseInfoRepository.findById(model.getId()).get();
            enterpriseInfoEntity.setName(model.getName());
            enterpriseInfoEntity.setCorporate(model.getCorporate());
            enterpriseInfoEntity.setTypeId(model.getTypeId());
            enterpriseInfoEntity.setTypeName(model.getTypeName());
            enterpriseInfoEntity.setAddress(model.getAddress());
            enterpriseInfoEntity.setLongitude(model.getLongitude());
            enterpriseInfoEntity.setLatitude(model.getLatitude());
            enterpriseInfoEntity.setSocialSecurityNum(model.getSocialSecurityNum());
            enterpriseInfoEntity.setContact(model.getContact());
            enterpriseInfoEntity.setContactPhone(model.getContactPhone());
            enterpriseInfoEntity.setCreditCode(model.getCreditCode());
            enterpriseInfoEntity.setLocalNum(model.getLocalNum());
            enterpriseInfoEntity.setOtherNum(model.getOtherNum());
        }
        return enterpriseInfoMapper.entityToModel(
                enterpriseInfoRepository.save(enterpriseInfoEntity));
    }

    /**
     * 根据企业Id删除
     * @param id
     * @return
     */
    public boolean delEnterpriseInfoById(String id){
        try{
            enterpriseInfoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 组装分页条件
     * @param queryInfo
     * @return
     */
    private Specification<EnterpriseInfoEntity> createSpecification(EnterpriseInfoQueryInfo queryInfo) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtil.isNotEmpty(queryInfo.getAreaName())) {
                predicates.add(cb.like(root.get("areaName"), queryInfo.getAreaName()));
            }
            if (StringUtil.isNotEmpty(queryInfo.getName())) {
                predicates.add(cb.like(root.get("name"), queryInfo.getName()));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
