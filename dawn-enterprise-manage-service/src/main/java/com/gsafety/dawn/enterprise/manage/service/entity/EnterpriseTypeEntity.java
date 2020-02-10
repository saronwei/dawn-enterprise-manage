package com.gsafety.dawn.enterprise.manage.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @create 2020-02-010 23:51
 */
@Entity
@Table(name = "d_enterprise_type")
public class EnterpriseTypeEntity {

    /**
     * 主键类型编号.
     */
    @Id
    @Column(name = "enterprise_type_id",length = 255,nullable = false)
    private String enterpriseTypeId;

    /**
     * 类型等级，用于快速查询，第几级节点.
     */
    @Column(name = "enterprise_type_level",length = 255,nullable = false)
    private String enterpriseTypeLevel;

    /**
     * 类型名称.
     */
    @Column(name = "enterprise_type_name",length = 255,nullable = false)
    private String enterpriseTypeName;

    /**
     * 类型父ID.
     */
    @Column(name = "enterprise_type_parent_id",length = 255,nullable = false)
    private String enterpriseTypeParentId;


    /**
     * Instantiates a new Resource entity.
     */
    public EnterpriseTypeEntity() {
        // 空构造方法
    }

    /**
     * Gets enterpriseTypeId.
     *
     * @return the enterpriseTypeId
     */
    public String getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    /**
     * Sets enterpriseTypeId.
     *
     * @param enterpriseTypeId the enterpriseTypeId
     */
    public void setEnterpriseTypeId(String enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId;
    }

    /**
     * Gets enterpriseTypeLevel.
     *
     * @return the enterpriseTypeLevel
     */
    public String getEnterpriseTypeLevel() {
        return enterpriseTypeLevel;
    }

    /**
     * Sets enterpriseTypeLevel.
     *
     * @param enterpriseTypeLevel the enterpriseTypeLevel
     */
    public void setEnterpriseTypeLevel(String enterpriseTypeLevel) {
        this.enterpriseTypeLevel = enterpriseTypeLevel;
    }

    /**
     * Gets enterpriseTypeName.
     *
     * @return the enterpriseTypeName
     */
    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }

    /**
     * Sets enterpriseTypeName.
     *
     * @param enterpriseTypeName the enterpriseTypeName
     */
    public void setEnterpriseTypeName(String enterpriseTypeName) {
        this.enterpriseTypeName = enterpriseTypeName;
    }

    /**
     * Gets res enterpriseTypeLevel.
     *
     * @return the res enterpriseTypeLevel
     */
    public String getEnterpriseTypeParentId() {
        return enterpriseTypeParentId;
    }

    /**
     * Sets res enterpriseTypeLevel.
     *
     * @param enterpriseTypeParentId the res enterpriseTypeLevel
     */
    public void setEnterpriseTypeParentId(String enterpriseTypeParentId) {
        this.enterpriseTypeParentId = enterpriseTypeParentId;
    }

}
