package com.gsafety.dawn.enterprise.manage.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "re_company_measure")
public class CompanyMeasureEntity {
    @Id
    @Column(name = "company_measure_id")
    private String companyMeasureId;
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "measure_id")
    private String measureId;

    public String getCompanyMeasureId() {
        return companyMeasureId;
    }

    public void setCompanyMeasureId(String companyMeasureId) {
        this.companyMeasureId = companyMeasureId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getMeasureId() {
        return measureId;
    }

    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }
}
