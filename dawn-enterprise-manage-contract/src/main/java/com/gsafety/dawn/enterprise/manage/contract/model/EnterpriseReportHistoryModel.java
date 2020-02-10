package com.gsafety.dawn.enterprise.manage.contract.model;

import java.util.Date;

/**
 * The type Enterprise report history model.
 */
public class EnterpriseReportHistoryModel {
    private String id;
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
     * Gets enterprise name.
     *
     * @return the enterprise name
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * Sets enterprise name.
     *
     * @param enterpriseName the enterprise name
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * Gets uniform social credit code.
     *
     * @return the uniform social credit code
     */
    public String getUniformSocialCreditCode() {
        return uniformSocialCreditCode;
    }

    /**
     * Sets uniform social credit code.
     *
     * @param uniformSocialCreditCode the uniform social credit code
     */
    public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
        this.uniformSocialCreditCode = uniformSocialCreditCode;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets type of enterprise.
     *
     * @return the type of enterprise
     */
    public String getTypeOfEnterprise() {
        return typeOfEnterprise;
    }

    /**
     * Sets type of enterprise.
     *
     * @param typeOfEnterprise the type of enterprise
     */
    public void setTypeOfEnterprise(String typeOfEnterprise) {
        this.typeOfEnterprise = typeOfEnterprise;
    }

    /**
     * Gets contact person name.
     *
     * @return the contact person name
     */
    public String getContactPersonName() {
        return contactPersonName;
    }

    /**
     * Sets contact person name.
     *
     * @param contactPersonName the contact person name
     */
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    /**
     * Gets contact person phone number.
     *
     * @return the contact person phone number
     */
    public String getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    /**
     * Sets contact person phone number.
     *
     * @param contactPersonPhoneNumber the contact person phone number
     */
    public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    /**
     * Gets total of insurer.
     *
     * @return the total of insurer
     */
    public Integer getTotalOfInsurer() {
        return totalOfInsurer;
    }

    /**
     * Sets total of insurer.
     *
     * @param totalOfInsurer the total of insurer
     */
    public void setTotalOfInsurer(Integer totalOfInsurer) {
        this.totalOfInsurer = totalOfInsurer;
    }

    /**
     * Gets enterprise arrivals.
     *
     * @return the enterprise arrivals
     */
    public Integer getEnterpriseArrivals() {
        return enterpriseArrivals;
    }

    /**
     * Sets enterprise arrivals.
     *
     * @param enterpriseArrivals the enterprise arrivals
     */
    public void setEnterpriseArrivals(Integer enterpriseArrivals) {
        this.enterpriseArrivals = enterpriseArrivals;
    }

    /**
     * Gets outsourced staff count.
     *
     * @return the outsourced staff count
     */
    public Integer getOutsourcedStaffCount() {
        return outsourcedStaffCount;
    }

    /**
     * Sets outsourced staff count.
     *
     * @param outsourcedStaffCount the outsourced staff count
     */
    public void setOutsourcedStaffCount(Integer outsourcedStaffCount) {
        this.outsourcedStaffCount = outsourcedStaffCount;
    }

    /**
     * Gets outsourced staff arrivals.
     *
     * @return the outsourced staff arrivals
     */
    public Integer getOutsourcedStaffArrivals() {
        return outsourcedStaffArrivals;
    }

    /**
     * Sets outsourced staff arrivals.
     *
     * @param outsourcedStaffArrivals the outsourced staff arrivals
     */
    public void setOutsourcedStaffArrivals(Integer outsourcedStaffArrivals) {
        this.outsourcedStaffArrivals = outsourcedStaffArrivals;
    }

    /**
     * Gets hubei citizen count.
     *
     * @return the hubei citizen count
     */
    public Integer getHubeiCitizenCount() {
        return hubeiCitizenCount;
    }

    /**
     * Sets hubei citizen count.
     *
     * @param hubeiCitizenCount the hubei citizen count
     */
    public void setHubeiCitizenCount(Integer hubeiCitizenCount) {
        this.hubeiCitizenCount = hubeiCitizenCount;
    }

    /**
     * Gets via hubei count.
     *
     * @return the via hubei count
     */
    public Integer getViaHubeiCount() {
        return viaHubeiCount;
    }

    /**
     * Sets via hubei count.
     *
     * @param viaHubeiCount the via hubei count
     */
    public void setViaHubeiCount(Integer viaHubeiCount) {
        this.viaHubeiCount = viaHubeiCount;
    }

    /**
     * Gets stay in huber count.
     *
     * @return the stay in huber count
     */
    public Integer getStayInHuberCount() {
        return stayInHuberCount;
    }

    /**
     * Sets stay in huber count.
     *
     * @param stayInHuberCount the stay in huber count
     */
    public void setStayInHuberCount(Integer stayInHuberCount) {
        this.stayInHuberCount = stayInHuberCount;
    }

    /**
     * Gets confirmed patients count.
     *
     * @return the confirmed patients count
     */
    public Integer getConfirmedPatientsCount() {
        return confirmedPatientsCount;
    }

    /**
     * Sets confirmed patients count.
     *
     * @param confirmedPatientsCount the confirmed patients count
     */
    public void setConfirmedPatientsCount(Integer confirmedPatientsCount) {
        this.confirmedPatientsCount = confirmedPatientsCount;
    }

    /**
     * Gets suspected patients count.
     *
     * @return the suspected patients count
     */
    public Integer getSuspectedPatientsCount() {
        return suspectedPatientsCount;
    }

    /**
     * Sets suspected patients count.
     *
     * @param suspectedPatientsCount the suspected patients count
     */
    public void setSuspectedPatientsCount(Integer suspectedPatientsCount) {
        this.suspectedPatientsCount = suspectedPatientsCount;
    }

    /**
     * Gets quarantine.
     *
     * @return the quarantine
     */
    public Integer getQuarantine() {
        return quarantine;
    }

    /**
     * Sets quarantine.
     *
     * @param quarantine the quarantine
     */
    public void setQuarantine(Integer quarantine) {
        this.quarantine = quarantine;
    }

    /**
     * Gets close contacts number.
     *
     * @return the close contacts number
     */
    public Integer getCloseContactsNumber() {
        return closeContactsNumber;
    }

    /**
     * Sets close contacts number.
     *
     * @param closeContactsNumber the close contacts number
     */
    public void setCloseContactsNumber(Integer closeContactsNumber) {
        this.closeContactsNumber = closeContactsNumber;
    }

    /**
     * Gets resume work.
     *
     * @return the resume work
     */
    public Boolean getResumeWork() {
        return resumeWork;
    }

    /**
     * Sets resume work.
     *
     * @param resumeWork the resume work
     */
    public void setResumeWork(Boolean resumeWork) {
        this.resumeWork = resumeWork;
    }

    /**
     * Gets resume work upload time.
     *
     * @return the resume work upload time
     */
    public Date getResumeWorkUploadTime() {
        return resumeWorkUploadTime;
    }

    /**
     * Sets resume work upload time.
     *
     * @param resumeWorkUploadTime the resume work upload time
     */
    public void setResumeWorkUploadTime(Date resumeWorkUploadTime) {
        this.resumeWorkUploadTime = resumeWorkUploadTime;
    }

    /**
     * Gets has trouble shooting.
     *
     * @return the has trouble shooting
     */
    public Boolean getHasTroubleShooting() {
        return hasTroubleShooting;
    }

    /**
     * Sets has trouble shooting.
     *
     * @param hasTroubleShooting the has trouble shooting
     */
    public void setHasTroubleShooting(Boolean hasTroubleShooting) {
        this.hasTroubleShooting = hasTroubleShooting;
    }

    /**
     * Gets point driven checked.
     *
     * @return the point driven checked
     */
    public Boolean getPointDrivenChecked() {
        return pointDrivenChecked;
    }

    /**
     * Sets point driven checked.
     *
     * @param pointDrivenChecked the point driven checked
     */
    public void setPointDrivenChecked(Boolean pointDrivenChecked) {
        this.pointDrivenChecked = pointDrivenChecked;
    }

    /**
     * Gets dangerous chemical storage sites.
     *
     * @return the dangerous chemical storage sites
     */
    public Boolean getDangerousChemicalStorageSites() {
        return dangerousChemicalStorageSites;
    }

    /**
     * Sets dangerous chemical storage sites.
     *
     * @param dangerousChemicalStorageSites the dangerous chemical storage sites
     */
    public void setDangerousChemicalStorageSites(Boolean dangerousChemicalStorageSites) {
        this.dangerousChemicalStorageSites = dangerousChemicalStorageSites;
    }

    /**
     * Gets head of pidemic prevention.
     *
     * @return the head of pidemic prevention
     */
    public String getHeadOfPidemicPrevention() {
        return headOfPidemicPrevention;
    }

    /**
     * Sets head of pidemic prevention.
     *
     * @param headOfPidemicPrevention the head of pidemic prevention
     */
    public void setHeadOfPidemicPrevention(String headOfPidemicPrevention) {
        this.headOfPidemicPrevention = headOfPidemicPrevention;
    }

    /**
     * Gets head of pidemic prevention contact.
     *
     * @return the head of pidemic prevention contact
     */
    public String getHeadOfPidemicPreventionContact() {
        return headOfPidemicPreventionContact;
    }

    /**
     * Sets head of pidemic prevention contact.
     *
     * @param headOfPidemicPreventionContact the head of pidemic prevention contact
     */
    public void setHeadOfPidemicPreventionContact(String headOfPidemicPreventionContact) {
        this.headOfPidemicPreventionContact = headOfPidemicPreventionContact;
    }

    /**
     * Gets body temperature monitor.
     *
     * @return the body temperature monitor
     */
    public Integer getBodyTemperatureMonitor() {
        return bodyTemperatureMonitor;
    }

    /**
     * Sets body temperature monitor.
     *
     * @param bodyTemperatureMonitor the body temperature monitor
     */
    public void setBodyTemperatureMonitor(Integer bodyTemperatureMonitor) {
        this.bodyTemperatureMonitor = bodyTemperatureMonitor;
    }

    /**
     * Gets number of masks.
     *
     * @return the number of masks
     */
    public Integer getNumberOfMasks() {
        return numberOfMasks;
    }

    /**
     * Sets number of masks.
     *
     * @param numberOfMasks the number of masks
     */
    public void setNumberOfMasks(Integer numberOfMasks) {
        this.numberOfMasks = numberOfMasks;
    }

    /**
     * Gets staff body temperature checked.
     *
     * @return the staff body temperature checked
     */
    public Boolean getStaffBodyTemperatureChecked() {
        return staffBodyTemperatureChecked;
    }

    /**
     * Sets staff body temperature checked.
     *
     * @param staffBodyTemperatureChecked the staff body temperature checked
     */
    public void setStaffBodyTemperatureChecked(Boolean staffBodyTemperatureChecked) {
        this.staffBodyTemperatureChecked = staffBodyTemperatureChecked;
    }

    /**
     * Gets important position disinfection.
     *
     * @return the important position disinfection
     */
    public Boolean getImportantPositionDisinfection() {
        return importantPositionDisinfection;
    }

    /**
     * Sets important position disinfection.
     *
     * @param importantPositionDisinfection the important position disinfection
     */
    public void setImportantPositionDisinfection(Boolean importantPositionDisinfection) {
        this.importantPositionDisinfection = importantPositionDisinfection;
    }

    /**
     * Gets closed management.
     *
     * @return the closed management
     */
    public Boolean getClosedManagement() {
        return closedManagement;
    }

    /**
     * Sets closed management.
     *
     * @param closedManagement the closed management
     */
    public void setClosedManagement(Boolean closedManagement) {
        this.closedManagement = closedManagement;
    }

    /**
     * Gets whether ventilation.
     *
     * @return the whether ventilation
     */
    public Boolean getWhetherVentilation() {
        return whetherVentilation;
    }

    /**
     * Sets whether ventilation.
     *
     * @param whetherVentilation the whether ventilation
     */
    public void setWhetherVentilation(Boolean whetherVentilation) {
        this.whetherVentilation = whetherVentilation;
    }

    /**
     * Gets has central air conditioning.
     *
     * @return the has central air conditioning
     */
    public Boolean getHasCentralAirConditioning() {
        return hasCentralAirConditioning;
    }

    /**
     * Sets has central air conditioning.
     *
     * @param hasCentralAirConditioning the has central air conditioning
     */
    public void setHasCentralAirConditioning(Boolean hasCentralAirConditioning) {
        this.hasCentralAirConditioning = hasCentralAirConditioning;
    }

    /**
     * Gets take measures.
     *
     * @return the take measures
     */
    public String getTakeMeasures() {
        return takeMeasures;
    }

    /**
     * Sets take measures.
     *
     * @param takeMeasures the take measures
     */
    public void setTakeMeasures(String takeMeasures) {
        this.takeMeasures = takeMeasures;
    }

    /**
     * Gets report time.
     *
     * @return the report time
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * Sets report time.
     *
     * @param reportTime the report time
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
}
