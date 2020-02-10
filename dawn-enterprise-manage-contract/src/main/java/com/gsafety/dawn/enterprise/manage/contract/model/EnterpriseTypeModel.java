package com.gsafety.dawn.enterprise.manage.contract.model;


import java.util.Date;

public class EnterpriseTypeModel {
    /**
     * 主键类型编号.
     */
    private String enterpriseTypeId;
    /**
     * 类型等级，用于快速查询，第几级节点.
     */
    private String enterpriseTypeLevel;
    /**
     * 类型名称.
     */
    private Date enterpriseTypeName;
    /**
     * 类型父ID.
     */
    private String enterpriseTypeParentId;
}
