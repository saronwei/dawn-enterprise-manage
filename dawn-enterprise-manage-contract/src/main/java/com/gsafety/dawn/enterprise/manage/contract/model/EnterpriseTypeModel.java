package com.gsafety.dawn.enterprise.manage.contract.model;


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
    private String enterpriseTypeName;
    /**
     * 类型父ID.
     */
    private String enterpriseTypeParentId;

    public EnterpriseTypeModel() {}

    public String getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(String enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId;
    }

    public String getEnterpriseTypeLevel() {
        return enterpriseTypeLevel;
    }

    public void setEnterpriseTypeLevel(String enterpriseTypeLevel) {
        this.enterpriseTypeLevel = enterpriseTypeLevel;
    }

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }

    public void setEnterpriseTypeName(String enterpriseTypeName) {
        this.enterpriseTypeName = enterpriseTypeName;
    }

    public String getEnterpriseTypeParentId() {
        return enterpriseTypeParentId;
    }

    public void setEnterpriseTypeParentId(String enterpriseTypeParentId) {
        this.enterpriseTypeParentId = enterpriseTypeParentId;
    }
}
