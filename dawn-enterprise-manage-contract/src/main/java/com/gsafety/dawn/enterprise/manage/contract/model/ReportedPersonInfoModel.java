package com.gsafety.dawn.enterprise.manage.contract.model;

public class ReportedPersonInfoModel {
    // 人员ID
    private String personId;
    // 人员名称
    private String personName;
    // 企业ID
    private String enterpriseId;
    // 企业名称
    private String enterpriseName;
    // 所在部门id
    private String deptId;
    // 所在部门
    private String deptName;
    // 性别
    private String sex;
    // 电话
    private String phone;
    // 是否有接触史
    private String isTouch;
    // 人员状态
    private String personStatus;
    // 填报时间
    private String reportTime;
    // 填报状态
    private String reportedStatus;
    // 症状
    private String symptom;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsTouch() {
        return isTouch;
    }

    public void setIsTouch(String isTouch) {
        this.isTouch = isTouch;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportedStatus() {
        return reportedStatus;
    }

    public void setReportedStatus(String reportedStatus) {
        this.reportedStatus = reportedStatus;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
