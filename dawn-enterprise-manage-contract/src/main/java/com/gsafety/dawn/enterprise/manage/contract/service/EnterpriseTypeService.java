package com.gsafety.dawn.enterprise.manage.contract.service;


import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseTypeModel;

import java.util.List;

/**
 * The interface enterprise type service.
 */
public interface EnterpriseTypeService {


    /**
     * 获取第一级节点类型
     * 主要用于快速展示信息使用，避免加载全部子类型耗时过长
     *
     * @return 第一级节点类型信息集合
     */
    List<EnterpriseTypeModel> getFirstLevelEnterprise();

    /**
     * 根据父节点获取所有子级节点信息
     * 此处目前只有2级节点，后续如有3级节点可再进行扩展
     *
     * @param parentId 父节点编号
     * @return 子级节点集合
     */
    List<EnterpriseTypeModel> getChildNodeEnterpriseById(String parentId);
}
