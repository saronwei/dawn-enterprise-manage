package com.gsafety.dawn.enterprise.manage.contract.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 企业基本信息Model
 */
public class EnterpriseInfoModel {
    private String id;

    private String name;

    private String corporate;

    private String typeId;

    private String typeName;

    private String areaId;

    private String areaName;

    private String address;

    private String longitude;

    private String latitude;

    private String creditCode;

    private String contact;

    private String contactPhone;

    private int socialSecurityNum;

    private int staffNum;

    private int localNum;

    private int otherNum;

    private String orders;

    private Date cTime;

    private Date mTime;

    private String tenAntId;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets 企业名称.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets 企业名称.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets 企业法人.
     *
     * @return the corporate
     */
    public String getCorporate() {
        return corporate;
    }

    /**
     * Sets 企业法人.
     *
     * @param corporate the corporate
     */
    public void setCorporate(String corporate) {
        this.corporate = corporate;
    }

    /**
     * Gets 企业类型.
     *
     * @return the type id
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Sets 企业类型.
     *
     * @param typeId the type id
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * Gets 企业类型名称.
     *
     * @return the type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets 企业类型名称.
     *
     * @param typeName the type name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Gets 企业区域.
     *
     * @return the areaId id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * Sets 企业区域
     *
     * @param areaId the area id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * Gets 企业区域名称.
     *
     * @return the area name
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets 企业区域名称.
     *
     * @param areaName the area name
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * Gets 企业地址.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets 企业地址.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets 统一社会信用代码.
     *
     * @return the credit code
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * Sets 统一社会信用代码.
     *
     * @param creditCode the credit code
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * Gets 企业联系人.
     *
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets 企业联系人.
     *
     * @param contact the contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets 企业联系人电话.
     *
     * @return the contact phone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets 企业联系人电话.
     *
     * @param contactPhone the contact phone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * Gets 缴纳社保总人数.
     *
     * @return the social security num
     */
    public int getSocialSecurityNum() {
        return socialSecurityNum;
    }

    /**
     * Sets 缴纳社保总人数.
     *
     * @param socialSecurityNum the social security num
     */
    public void setSocialSecurityNum(int socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }

    /**
     * Gets 员工总人数.
     *
     * @return the staff num
     */
    public int getStaffNum() {
        return staffNum;
    }

    /**
     * Sets 员工总人数.
     *
     * @param staffNum the staff num
     */
    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }

    /**
     * Gets 本地员工人数.
     *
     * @return the local num
     */
    public int getLocalNum() {
        return localNum;
    }

    /**
     * Sets 本地员工人数.
     *
     * @param localNum the local num
     */
    public void setLocalNum(int localNum) {
        this.localNum = localNum;
    }

    /**
     * Gets 外地员工人数.
     *
     * @return the other num
     */
    public int getOtherNum() {
        return otherNum;
    }

    /**
     * Sets 外地员工人数.
     *
     * @param otherNum the other num
     */
    public void setOtherNum(int otherNum) {
        this.otherNum = otherNum;
    }

    /**
     * Gets 排序号.
     *
     * @return the orders
     */
    public String getOrders() {
        return orders;
    }

    /**
     * Sets 排序号.
     *
     * @param orders the orders
     */
    public void setOrders(String orders) {
        this.orders = orders;
    }

    /**
     * Gets 创建时间.
     *
     * @return the time
     */
    public Date getcTime() {
        return cTime;
    }

    /**
     * Sets 创建时间.
     *
     * @param cTime the c time
     */
    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    /**
     * Gets 更新时间.
     *
     * @return the time
     */
    public Date getmTime() {
        return mTime;
    }

    /**
     * Sets 更新时间.
     *
     * @param mTime the m time
     */
    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    /**
     * Gets 租户Id.
     *
     * @return the ten ant id
     */
    public String getTenAntId() {
        return tenAntId;
    }

    /**
     * Sets 租户Id.
     *
     * @param tenAntId the ten ant id
     */
    public void setTenAntId(String tenAntId) {
        this.tenAntId = tenAntId;
    }
}
