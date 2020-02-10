package com.gsafety.dawn.enterprise.manage.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String enterprise_type_id;

    /**
     * 类型等级，用于快速查询，第几级节点.
     */
    @Column(name = "enterprise_type_level",length = 255,nullable = false)
    private String enterprise_type_level;

    /**
     * 类型名称.
     */
    @Column(name = "enterprise_type_name",length = 255,nullable = false)
    private String enterprise_type_name;

    /**
     * 类型父ID.
     */
    @Column(name = "enterprise_type_parent_id",length = 255,nullable = false)
    private String enterprise_type_parent_id;


    /**
     * Instantiates a new Resource entity.
     */
    public EnterpriseTypeEntity() {
        // 空构造方法
    }

    /**
     * Gets enterprise_type_id.
     *
     * @return the enterprise_type_id
     */
    public String getEnterprise_type_id() {
        return enterprise_type_id;
    }

    /**
     * Sets enterprise_type_id.
     *
     * @param enterprise_type_id the enterprise_type_id
     */
    public void setEnterprise_type_id(String enterprise_type_id) {
        this.enterprise_type_id = enterprise_type_id;
    }

    /**
     * Gets enterprise_type_level.
     *
     * @return the enterprise_type_level
     */
    public String getEnterprise_type_level() {
        return enterprise_type_level;
    }

    /**
     * Sets enterprise_type_level.
     *
     * @param enterprise_type_level the enterprise_type_level
     */
    public void setEnterprise_type_level(String enterprise_type_level) {
        this.enterprise_type_level = enterprise_type_level;
    }

    /**
     * Gets enterprise_type_name.
     *
     * @return the enterprise_type_name
     */
    public String getEnterprise_type_name() {
        return enterprise_type_name;
    }

    /**
     * Sets enterprise_type_name.
     *
     * @param enterprise_type_name the enterprise_type_name
     */
    public void setEnterprise_type_name(String enterprise_type_name) {
        this.enterprise_type_name = enterprise_type_name;
    }

    /**
     * Gets res enterprise_type_level.
     *
     * @return the res enterprise_type_level
     */
    public String getEnterprise_type_parent_id() {
        return enterprise_type_parent_id;
    }

    /**
     * Sets res enterprise_type_level.
     *
     * @param enterprise_type_parent_id the res enterprise_type_level
     */
    public void setEnterprise_type_parent_id(String enterprise_type_parent_id) {
        this.enterprise_type_parent_id = enterprise_type_parent_id;
    }

}
