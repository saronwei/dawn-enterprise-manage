package com.gsafety.dawn.enterprise.manage.service.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "be_company_report")
public class CompanyReportEntity {
    @Id
    @Column(name = "report_id")
    private String reportId;
    @Column(name = "company_id")
    private String companyId;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_resume")
    private Boolean resume;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "resume_date")
    private Date resumeDate;
    @Column(name = "prevention_person")
    private String preventionPerson;
    @Column(name = "prevention_phone")
    private String preventionPhone;
    @Column(name = "dining_plan")
    private String diningPlan;
    @Column(name = "measures")
    private String measures;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_craft_check")
    private Boolean craftCheck;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_danger_storage")
    private Boolean dangerStorage;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_danger_check")
    private Boolean dangerCheck;
    @Column(name = "risk_degree")
    private String riskDegree;
    @Temporal(TemporalType.DATE)
    @Column(name = "report_date")
    private Date reportDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ctime")
    private Date ctime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mtime")
    private Date mtime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false)
    private EnterpriseInfoEntity enterpriseInfoEntity;

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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
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

    public EnterpriseInfoEntity getEnterpriseInfoEntity() {
        return enterpriseInfoEntity;
    }

    public void setEnterpriseInfoEntity(EnterpriseInfoEntity enterpriseInfoEntity) {
        this.enterpriseInfoEntity = enterpriseInfoEntity;
    }
}
