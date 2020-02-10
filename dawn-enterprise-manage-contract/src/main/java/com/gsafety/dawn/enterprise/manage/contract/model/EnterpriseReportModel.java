package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel
public class EnterpriseReportModel {
    private String reportId;
    // 企业名称
    private String enterpriseName;
    //  统一社会信用代码
    private String uniformSocialCreditCode;
    // 3、        地址
    private String address;
    // 4、        企业类型（服务、软件、医疗等）
    private String typeOfEnterprise;
    // 5、        企业联系人名称
    private String contactPersonName;
    // 6、        企业联系人电话
    private String contactPersonPhoneNumber;
    // 7、        企业缴纳社保总人数
    private Integer totalOfInsurer;
    // 8、        企业到岗人数
    private Integer enterpriseArrivals;
    // 9、        外包人员数量
    private Integer outsourcedStaffCount;
    // 10、        外包到岗人数
    private Integer outsourcedStaffArrivals;
    // 11、        湖北籍人数
    private Integer hubeiCitizenCount;
    // 12、        途径湖北人数
    private Integer viaHubeiCount;
    // 13、        停留湖北人数
    private Integer stayInHuberCount;
    // 14、        确诊人数
    private Integer confirmedPatientsCount;
    // 15、        疑似人数
    private Integer suspectedPatientsCount;
    // 16、        隔离观察人数
    private Integer quarantine;
    // 17、        密接人数
    private Integer closeContactsNumber;
    // 18、        企业复工（是、否）
    private Boolean resumeWork;
    // 19、        复工报备时间
    private Date resumeWorkUploadTime;
    // 20、        员工健康档案（可点击查看每日的员工上报情况）staffHealthDatas
    // 21、        企业复工隐患排查（是、否）
    private Boolean hasTroubleShooting;
    // 22、        重点工艺开车检查（是、否）
    private Boolean pointDrivenChecked;
    // 23、        危险化学品存储场所（是、否；如果是可点击查看存量和种类）
    private Boolean dangerousChemicalStorageSites;
    // 24、        防疫负责人
    private String headOfPidemicPrevention;
    // 25、        防疫负责人联系方式
    private String headOfPidemicPreventionContact;
    // 26、        快速体温检测仪-数量
    private Integer bodyTemperatureMonitor = 0;
    // 27、        口罩配备-数量
    private Integer numberOfMasks;
    // 28、        员工每人体温检测（是、否）
    private Boolean staffBodyTemperatureChecked;
    // 29、        重点部位消杀（是、否）--解释重点点位厕所、食堂、会议室、宿舍。
    private Boolean importantPositionDisinfection;
    // 30、        是否封闭管理（是、否）
    private Boolean closedManagement;
    // 31、        密集场所是否通风（是、否）
    private Boolean whetherVentilation;
    // 32、        中央空调（是、否）
    private Boolean hasCentralAirConditioning;
    // 33、        采取措施（消毒、关闭、未消毒）
    private String takeMeasures;

    private Date reportTime;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getUniformSocialCreditCode() {
        return uniformSocialCreditCode;
    }

    public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
        this.uniformSocialCreditCode = uniformSocialCreditCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeOfEnterprise() {
        return typeOfEnterprise;
    }

    public void setTypeOfEnterprise(String typeOfEnterprise) {
        this.typeOfEnterprise = typeOfEnterprise;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public Integer getTotalOfInsurer() {
        return totalOfInsurer;
    }

    public void setTotalOfInsurer(Integer totalOfInsurer) {
        this.totalOfInsurer = totalOfInsurer;
    }

    public Integer getEnterpriseArrivals() {
        return enterpriseArrivals;
    }

    public void setEnterpriseArrivals(Integer enterpriseArrivals) {
        this.enterpriseArrivals = enterpriseArrivals;
    }

    public Integer getOutsourcedStaffCount() {
        return outsourcedStaffCount;
    }

    public void setOutsourcedStaffCount(Integer outsourcedStaffCount) {
        this.outsourcedStaffCount = outsourcedStaffCount;
    }

    public Integer getOutsourcedStaffArrivals() {
        return outsourcedStaffArrivals;
    }

    public void setOutsourcedStaffArrivals(Integer outsourcedStaffArrivals) {
        this.outsourcedStaffArrivals = outsourcedStaffArrivals;
    }

    public Integer getHubeiCitizenCount() {
        return hubeiCitizenCount;
    }

    public void setHubeiCitizenCount(Integer hubeiCitizenCount) {
        this.hubeiCitizenCount = hubeiCitizenCount;
    }

    public Integer getViaHubeiCount() {
        return viaHubeiCount;
    }

    public void setViaHubeiCount(Integer viaHubeiCount) {
        this.viaHubeiCount = viaHubeiCount;
    }

    public Integer getStayInHuberCount() {
        return stayInHuberCount;
    }

    public void setStayInHuberCount(Integer stayInHuberCount) {
        this.stayInHuberCount = stayInHuberCount;
    }

    public Integer getConfirmedPatientsCount() {
        return confirmedPatientsCount;
    }

    public void setConfirmedPatientsCount(Integer confirmedPatientsCount) {
        this.confirmedPatientsCount = confirmedPatientsCount;
    }

    public Integer getSuspectedPatientsCount() {
        return suspectedPatientsCount;
    }

    public void setSuspectedPatientsCount(Integer suspectedPatientsCount) {
        this.suspectedPatientsCount = suspectedPatientsCount;
    }

    public Integer getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Integer quarantine) {
        this.quarantine = quarantine;
    }

    public Integer getCloseContactsNumber() {
        return closeContactsNumber;
    }

    public void setCloseContactsNumber(Integer closeContactsNumber) {
        this.closeContactsNumber = closeContactsNumber;
    }

    public Boolean getResumeWork() {
        return resumeWork;
    }

    public void setResumeWork(Boolean resumeWork) {
        this.resumeWork = resumeWork;
    }

    public Date getResumeWorkUploadTime() {
        return resumeWorkUploadTime;
    }

    public void setResumeWorkUploadTime(Date resumeWorkUploadTime) {
        this.resumeWorkUploadTime = resumeWorkUploadTime;
    }

    public Boolean getHasTroubleShooting() {
        return hasTroubleShooting;
    }

    public void setHasTroubleShooting(Boolean hasTroubleShooting) {
        this.hasTroubleShooting = hasTroubleShooting;
    }

    public Boolean getPointDrivenChecked() {
        return pointDrivenChecked;
    }

    public void setPointDrivenChecked(Boolean pointDrivenChecked) {
        this.pointDrivenChecked = pointDrivenChecked;
    }

    public Boolean getDangerousChemicalStorageSites() {
        return dangerousChemicalStorageSites;
    }

    public void setDangerousChemicalStorageSites(Boolean dangerousChemicalStorageSites) {
        this.dangerousChemicalStorageSites = dangerousChemicalStorageSites;
    }

    public String getHeadOfPidemicPrevention() {
        return headOfPidemicPrevention;
    }

    public void setHeadOfPidemicPrevention(String headOfPidemicPrevention) {
        this.headOfPidemicPrevention = headOfPidemicPrevention;
    }

    public String getHeadOfPidemicPreventionContact() {
        return headOfPidemicPreventionContact;
    }

    public void setHeadOfPidemicPreventionContact(String headOfPidemicPreventionContact) {
        this.headOfPidemicPreventionContact = headOfPidemicPreventionContact;
    }

    public Integer getBodyTemperatureMonitor() {
        return bodyTemperatureMonitor;
    }

    public void setBodyTemperatureMonitor(Integer bodyTemperatureMonitor) {
        this.bodyTemperatureMonitor = bodyTemperatureMonitor;
    }

    public Integer getNumberOfMasks() {
        return numberOfMasks;
    }

    public void setNumberOfMasks(Integer numberOfMasks) {
        this.numberOfMasks = numberOfMasks;
    }

    public Boolean getStaffBodyTemperatureChecked() {
        return staffBodyTemperatureChecked;
    }

    public void setStaffBodyTemperatureChecked(Boolean staffBodyTemperatureChecked) {
        this.staffBodyTemperatureChecked = staffBodyTemperatureChecked;
    }

    public Boolean getImportantPositionDisinfection() {
        return importantPositionDisinfection;
    }

    public void setImportantPositionDisinfection(Boolean importantPositionDisinfection) {
        this.importantPositionDisinfection = importantPositionDisinfection;
    }

    public Boolean getClosedManagement() {
        return closedManagement;
    }

    public void setClosedManagement(Boolean closedManagement) {
        this.closedManagement = closedManagement;
    }

    public Boolean getWhetherVentilation() {
        return whetherVentilation;
    }

    public void setWhetherVentilation(Boolean whetherVentilation) {
        this.whetherVentilation = whetherVentilation;
    }

    public Boolean getHasCentralAirConditioning() {
        return hasCentralAirConditioning;
    }

    public void setHasCentralAirConditioning(Boolean hasCentralAirConditioning) {
        this.hasCentralAirConditioning = hasCentralAirConditioning;
    }

    public String getTakeMeasures() {
        return takeMeasures;
    }

    public void setTakeMeasures(String takeMeasures) {
        this.takeMeasures = takeMeasures;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
}
