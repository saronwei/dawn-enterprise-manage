package com.gsafety.dawn.enterprise.manage.service.entity.cg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "e_company_report_info")
public class CompanyReportInfoEntity {
    @Id
    @Column(name = "id", length = 64, nullable = false)
    private String id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "social_credit_code", length = 128)
    private String socialCreditCode;

    @Column(name = "address", length = 128 )
    private String address;

    @Column(name = "type", length = 20 )
    private String type;

    @Column(name = "contact_name", length = 128)
    private String contactName;

    @Column(name = "contact_phone", length = 20)
    private String contactPhone;

    @Column(name = "social_security_total")
    private Integer socialSecurityTotal;

    //企业到岗人数
    @Column(name = "on_work_in_total")
    private Integer onWorkInTotal;

    //外包人员总数
    @Column(name = "out_total")
    private Integer outTotal;

    // 外包到岗人数
    @Column(name = "on_work_out_total")
    private Integer onWorkOutTotal;

    @Column(name = "hubei_total")
    private Integer hubeiTotal;

    @Column(name = "throuth_hubei_total")
    private Integer throuthHubeiTotal;

    @Column(name = "stay_hubei_total")
    private Integer stayHubeiTotal;

    @Column(name = "diagnosis_total")
    private Integer diagnosisTotal;

    @Column(name = "doubt_total")
    private Integer doubtTotal;


    @Column(name = "isolate_total")
    private Integer isolateTotal;

    @Column(name = "close_look_total")
    private Integer closeLookTotal;

    @Column(name = "is_return_work")
    private Integer isRetrunWork;

    //员工健康档案？

   //时间
    @Column(name = "return_work_time")
    private Date returnWorkTime;

    @Column(name = "is_check_hidden_danger")
    private Integer isCheckHiddenDanger;

    @Column(name = "is_check_key_tech")
    private Integer isCheckKeyTech;

    @Column(name = "is_check_danger_chemical")
    private Integer isCheckDangerChemical;


    @Column(name = "prevention_person", length = 50 )
    private String preventionPerson;

    @Column(name = "prevention_person_phone", length = 50 )
    private String preventionPersonPhone;

    @Column(name = "thermometer_total")
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
