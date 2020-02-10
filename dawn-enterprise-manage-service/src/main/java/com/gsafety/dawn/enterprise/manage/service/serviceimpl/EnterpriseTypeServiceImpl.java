package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseTypeModel;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseTypeService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.EnterpriseTypeMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseTypeEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type enterprise type service.
 */
@Service
@Transactional
public class EnterpriseTypeServiceImpl implements EnterpriseTypeService {

    /**
     * 转换器
     */
    @Autowired
    private EnterpriseTypeMapper enterpriseTypeMapper;
    /**
     * repository
     */
    @Autowired
    private EnterpriseTypeRepository enterpriseTypeRepository;

    /**
     * 获取第一级节点类型
     * 主要用于快速展示信息使用，避免加载全部子类型耗时过长
     *
     * @return 第一级节点类型信息集合
     */
    @Override
    public List<EnterpriseTypeModel> getFirstLevelEnterprise() {
        List<EnterpriseTypeEntity> enterpriseTypeEntities =
                enterpriseTypeRepository.getByFirstLevel("1");
        List<EnterpriseTypeModel> enterpriseTypeModels =
                enterpriseTypeMapper.entitiesToModels(enterpriseTypeEntities);
        return enterpriseTypeModels;
    }

    /**
     * 根据父节点获取所有子级节点信息
     * 此处目前只有2级节点，后续如有3级节点可再进行扩展
     *
     * @param parentId 父节点编号
     * @return 子级节点集合
     */
    @Override
    public List<EnterpriseTypeModel> getChildNodeEnterpriseById(String parentId) {
        List<EnterpriseTypeEntity> enterpriseTypeEntities =
                enterpriseTypeRepository.getByParentId(parentId);
        List<EnterpriseTypeModel> enterpriseTypeModels =
                enterpriseTypeMapper.entitiesToModels(enterpriseTypeEntities);
        return enterpriseTypeModels;
    }
}
