package com.gsafety.dawn.enterprise.manage.contract.model.cg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class StaffReturnInfoModel {

    private String id;

    // 姓名
    private String name;
    // 所属单位
    private String unit;
    // 员工编号
    private String number;
    // 身份证号
    private String identificationNumber;
    // 性别
    private String sex;
    // 所属部门
    private String department;
    // 工作岗位
    private String job;
    // 联系电话
    private String phone;
    // 住址
    private String address;
    // 在岗状态
    private String workerStatue;
    // 预计返岗日期
    private String expectedReturnDate;
    // 近期是否离开固定驻地
    private String isLeaveReturnPost;
    // 离开固定驻地时间
    private String leaveReturnPostTime;
    // 所赴城市
    private String goCity;
    // 是否已返回
    private String isReturn;
    // 目前所在城市
    private String currentCity;
    // 返回时间
    private String returnTime;
    // 离开与返回的交通工具
    private String transport;
    // 1月1日之后是否去过湖北
    private String isToHubei;
    // 是否经停湖北
    private String isPassHubei;
    // 计划返回时间
    private String planReturnTime;
    // 离开期间是否与湖北地区的人员接触
    private String isContactHubeiPerson;
    // 14日内是否接触武汉来人
    private String isTouchWuhan;
    // 14日内是否接触湖北来人
    private String isTouchHubei;
    // 是否发热
    private String isExceedTemp;
    // 其他症状
    private String otherSymptomsList;
    // otherSymptoms: '其他',
    // 一起返回的家属
    private String family;
    // 家属身体状况
    private String familyHealth;
    // 是否向所在社区居委会报到
    private String isCommitteeReport;
    // 外地返回是否做自我居家隔离
    private String isIsolation;
    // 其他
    private String other;
    // 是否上报
    private String isWrite;
    // 填写时间
    private String reportTime;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkerStatue() {
        return workerStatue;
    }

    public void setWorkerStatue(String workerStatue) {
        this.workerStatue = workerStatue;
    }

    public String getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(String expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getIsLeaveReturnPost() {
        return isLeaveReturnPost;
    }

    public void setIsLeaveReturnPost(String isLeaveReturnPost) {
        this.isLeaveReturnPost = isLeaveReturnPost;
    }

    public String getLeaveReturnPostTime() {
        return leaveReturnPostTime;
    }

    public void setLeaveReturnPostTime(String leaveReturnPostTime) {
        this.leaveReturnPostTime = leaveReturnPostTime;
    }

    public String getGoCity() {
        return goCity;
    }

    public void setGoCity(String goCity) {
        this.goCity = goCity;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getIsToHubei() {
        return isToHubei;
    }

    public void setIsToHubei(String isToHubei) {
        this.isToHubei = isToHubei;
    }

    public String getIsPassHubei() {
        return isPassHubei;
    }

    public void setIsPassHubei(String isPassHubei) {
        this.isPassHubei = isPassHubei;
    }

    public String getPlanReturnTime() {
        return planReturnTime;
    }

    public void setPlanReturnTime(String planReturnTime) {
        this.planReturnTime = planReturnTime;
    }

    public String getIsContactHubeiPerson() {
        return isContactHubeiPerson;
    }

    public void setIsContactHubeiPerson(String isContactHubeiPerson) {
        this.isContactHubeiPerson = isContactHubeiPerson;
    }

    public String getIsTouchWuhan() {
        return isTouchWuhan;
    }

    public void setIsTouchWuhan(String isTouchWuhan) {
        this.isTouchWuhan = isTouchWuhan;
    }

    public String getIsTouchHubei() {
        return isTouchHubei;
    }

    public void setIsTouchHubei(String isTouchHubei) {
        this.isTouchHubei = isTouchHubei;
    }

    public String getIsExceedTemp() {
        return isExceedTemp;
    }

    public void setIsExceedTemp(String isExceedTemp) {
        this.isExceedTemp = isExceedTemp;
    }

    public String getOtherSymptomsList() {
        return otherSymptomsList;
    }

    public void setOtherSymptomsList(String otherSymptomsList) {
        this.otherSymptomsList = otherSymptomsList;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFamilyHealth() {
        return familyHealth;
    }

    public void setFamilyHealth(String familyHealth) {
        this.familyHealth = familyHealth;
    }

    public String getIsCommitteeReport() {
        return isCommitteeReport;
    }

    public void setIsCommitteeReport(String isCommitteeReport) {
        this.isCommitteeReport = isCommitteeReport;
    }

    public String getIsIsolation() {
        return isIsolation;
    }

    public void setIsIsolation(String isIsolation) {
        this.isIsolation = isIsolation;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(String isWrite) {
        this.isWrite = isWrite;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
}
