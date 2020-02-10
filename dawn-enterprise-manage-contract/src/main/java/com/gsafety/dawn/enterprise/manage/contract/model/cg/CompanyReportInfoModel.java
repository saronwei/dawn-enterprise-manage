package com.gsafety.dawn.enterprise.manage.contract.model.cg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class CompanyReportInfoModel {
    private String id;

    
    private String name;

    
    private String socialCreditCode;

    
    private String address;

    
    private String type;

    
    private String contactName;

    
    private String contactPhone;

    
    private Integer socialSecurityTotal;

    
    private Integer onWorkInTotal;

    
    private Integer outTotal;

    
    private Integer onWorkOutTotal;

    
    private Integer hubeiTotal;

    
    private Integer throuthHubeiTotal;

    
    private Integer stayHubeiTotal;

    
    private Integer diagnosisTotal;

    
    private Integer doubtTotal;


    
    private Integer isolateTotal;

    
    private Integer closeLookTotal;

    
    private Integer isRetrunWork;

    //员工健康档案？

   //时间
    
    private Date returnWorkTime;

    
    private Integer isCheckHiddenDanger;

    
    private Integer isCheckKeyTech;

    
    private Integer isCheckDangerChemical;


    
    private String preventionPerson;

    
    private String preventionPersonPhone;

    
    private Integer thermometerTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getSocialSecurityTotal() {
        return socialSecurityTotal;
    }

    public void setSocialSecurityTotal(Integer socialSecurityTotal) {
        this.socialSecurityTotal = socialSecurityTotal;
    }

    public Integer getOnWorkInTotal() {
        return onWorkInTotal;
    }

    public void setOnWorkInTotal(Integer onWorkInTotal) {
        this.onWorkInTotal = onWorkInTotal;
    }

    public Integer getOutTotal() {
        return outTotal;
    }

    public void setOutTotal(Integer outTotal) {
        this.outTotal = outTotal;
    }

    public Integer getOnWorkOutTotal() {
        return onWorkOutTotal;
    }

    public void setOnWorkOutTotal(Integer onWorkOutTotal) {
        this.onWorkOutTotal = onWorkOutTotal;
    }

    public Integer getHubeiTotal() {
        return hubeiTotal;
    }

    public void setHubeiTotal(Integer hubeiTotal) {
        this.hubeiTotal = hubeiTotal;
    }

    public Integer getThrouthHubeiTotal() {
        return throuthHubeiTotal;
    }

    public void setThrouthHubeiTotal(Integer throuthHubeiTotal) {
        this.throuthHubeiTotal = throuthHubeiTotal;
    }

    public Integer getStayHubeiTotal() {
        return stayHubeiTotal;
    }

    public void setStayHubeiTotal(Integer stayHubeiTotal) {
        this.stayHubeiTotal = stayHubeiTotal;
    }

    public Integer getDiagnosisTotal() {
        return diagnosisTotal;
    }

    public void setDiagnosisTotal(Integer diagnosisTotal) {
        this.diagnosisTotal = diagnosisTotal;
    }

    public Integer getDoubtTotal() {
        return doubtTotal;
    }

    public void setDoubtTotal(Integer doubtTotal) {
        this.doubtTotal = doubtTotal;
    }

    public Integer getIsolateTotal() {
        return isolateTotal;
    }

    public void setIsolateTotal(Integer isolateTotal) {
        this.isolateTotal = isolateTotal;
    }

    public Integer getCloseLookTotal() {
        return closeLookTotal;
    }

    public void setCloseLookTotal(Integer closeLookTotal) {
        this.closeLookTotal = closeLookTotal;
    }

    public Integer getIsRetrunWork() {
        return isRetrunWork;
    }

    public void setIsRetrunWork(Integer isRetrunWork) {
        this.isRetrunWork = isRetrunWork;
    }

    public Date getReturnWorkTime() {
        return returnWorkTime;
    }

    public void setReturnWorkTime(Date returnWorkTime) {
        this.returnWorkTime = returnWorkTime;
    }

    public Integer getIsCheckHiddenDanger() {
        return isCheckHiddenDanger;
    }

    public void setIsCheckHiddenDanger(Integer isCheckHiddenDanger) {
        this.isCheckHiddenDanger = isCheckHiddenDanger;
    }

    public Integer getIsCheckKeyTech() {
        return isCheckKeyTech;
    }

    public void setIsCheckKeyTech(Integer isCheckKeyTech) {
        this.isCheckKeyTech = isCheckKeyTech;
    }

    public Integer getIsCheckDangerChemical() {
        return isCheckDangerChemical;
    }

    public void setIsCheckDangerChemical(Integer isCheckDangerChemical) {
        this.isCheckDangerChemical = isCheckDangerChemical;
    }

    public String getPreventionPerson() {
        return preventionPerson;
    }

    public void setPreventionPerson(String preventionPerson) {
        this.preventionPerson = preventionPerson;
    }

    public String getPreventionPersonPhone() {
        return preventionPersonPhone;
    }

    public void setPreventionPersonPhone(String preventionPersonPhone) {
        this.preventionPersonPhone = preventionPersonPhone;
    }

    public Integer getThermometerTotal() {
        return thermometerTotal;
    }

    public void setThermometerTotal(Integer thermometerTotal) {
        this.thermometerTotal = thermometerTotal;
    }
}
