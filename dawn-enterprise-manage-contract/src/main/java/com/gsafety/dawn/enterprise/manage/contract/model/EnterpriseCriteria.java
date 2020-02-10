package com.gsafety.dawn.enterprise.manage.contract.model;


import java.util.Date;

public class EnterpriseCriteria {
    // 企业id
    private String enterpriseCode;
    // 企业名称
    private String enterpriseName;
    // 日期
    private String startDate;

    private String endDate;
    // 部门id
    private String deptmentCode;
    // 部门名称
    private String deptmentName;
    // 填报状态
    private String uploadStatus;
    // 人员状态
    private String personStatus;

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getDeptmentCode() {
        return deptmentCode;
    }

    public void setDeptmentCode(String deptmentCode) {
        this.deptmentCode = deptmentCode;
    }

    public String getDeptmentName() {
        return deptmentName;
    }

    public void setDeptmentName(String deptmentName) {
        this.deptmentName = deptmentName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }
}
