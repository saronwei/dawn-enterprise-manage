package com.gsafety.dawn.enterprise.manage.contract.model;

import java.util.Date;

public class CompanyReportModel {
    private String reportId;
    private String companyId;
    private Boolean resume;
    private Date resumeDate;
    private String preventionPerson;
    private String preventionPhone;
    private String diningPlan;
    private String measures;
    private Boolean craftCheck;
    private Boolean dangerStorage;
    private Boolean dangerCheck;
    private String riskDegree;
    private Date ctime;
    private Date mtime;

    private EnterpriseInfoModel enterpriseInfoModel;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Boolean getResume() {
        return resume;
    }

    public void setResume(Boolean resume) {
        this.resume = resume;
    }

    public Date getResumeDate() {
        return resumeDate;
    }

    public void setResumeDate(Date resumeDate) {
        this.resumeDate = resumeDate;
    }

    public String getPreventionPerson() {
        return preventionPerson;
    }

    public void setPreventionPerson(String preventionPerson) {
        this.preventionPerson = preventionPerson;
    }

    public String getPreventionPhone() {
        return preventionPhone;
    }

    public void setPreventionPhone(String preventionPhone) {
        this.preventionPhone = preventionPhone;
    }

    public String getDiningPlan() {
        return diningPlan;
    }

    public void setDiningPlan(String diningPlan) {
        this.diningPlan = diningPlan;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public Boolean getCraftCheck() {
        return craftCheck;
    }

    public void setCraftCheck(Boolean craftCheck) {
        this.craftCheck = craftCheck;
    }

    public Boolean getDangerStorage() {
        return dangerStorage;
    }

    public void setDangerStorage(Boolean dangerStorage) {
        this.dangerStorage = dangerStorage;
    }

    public Boolean getDangerCheck() {
        return dangerCheck;
    }

    public void setDangerCheck(Boolean dangerCheck) {
        this.dangerCheck = dangerCheck;
    }

    public String getRiskDegree() {
        return riskDegree;
    }

    public void setRiskDegree(String riskDegree) {
        this.riskDegree = riskDegree;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public EnterpriseInfoModel getEnterpriseInfoModel() {
        return enterpriseInfoModel;
    }

    public void setEnterpriseInfoModel(EnterpriseInfoModel enterpriseInfoModel) {
        this.enterpriseInfoModel = enterpriseInfoModel;
    }
}
