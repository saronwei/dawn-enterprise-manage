package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class EnterpriseReport {

    @ApiModelProperty(value = "")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;
    @ApiModelProperty(value = "企业编码")
    private String enterpriseCode;
    @ApiModelProperty(value = "人员编号")
    private String employeeCode;
    @ApiModelProperty(value = "身份证号")
    private String idNumber;
    @ApiModelProperty(value = "性别 (0男 1女)")
    private Integer sex;
    @ApiModelProperty(value = "部门编码")
    private String deptmentCode;
    @ApiModelProperty(value = "部门名称")
    private String deptmentName;
    @ApiModelProperty(value = "工作岗位（正式合同制、临时聘用）")
    private String job;
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ApiModelProperty(value = "固定居住地址")
    private String address;
    @ApiModelProperty(value = "在岗状态（1远程在岗、2现场在岗，3离岗，4出差，5休假）")
    private Integer dutyStatus;
    @ApiModelProperty(value = "预计返岗日期")
    private String postDate;
    @ApiModelProperty(value = "离开固定驻地时间")
    private String leaveDate;
    @ApiModelProperty(value = "近期是否离开固定驻地（1是,0否）")
    private Integer leaveHabitation;
    @ApiModelProperty(value = "所赴城市（可以是多个）")
    private String toCity;
    @ApiModelProperty(value = "是否已返回（1是、0否）")
    private Integer back;
    @ApiModelProperty(value = "目前所在城市")
    private String currentCityName;
    @ApiModelProperty(value = "返回时间")
    private String backDate;
    @ApiModelProperty(value = "离开与返回的交通工具（飞机、火车、大巴、自驾车）及车次、航班次等（可以是多个）")
    private String vehicle;
    @ApiModelProperty(value = "1月1日以后是否去过湖北（0没去过1去过）")
    private Integer beenHubei;
    @ApiModelProperty(value = "是否经停湖北（1是,0否）")
    private Integer passHubei;
    @ApiModelProperty(value = "计划返回时间")
    private String planBackDate;
    @ApiModelProperty(value = "离开期间是否与湖北地区的人员接触")
    private Integer touchHubei;
    @ApiModelProperty(value = "14日内是否接触过武汉来人（1是,0否）")
    private Integer fourteenDayTouchWuhan;
    @ApiModelProperty(value = "14日内是否接触过湖北来人（1是,0否）")
    private Integer fourteenDayTouchHubei;
    @ApiModelProperty(value = "是否发热（>=37.3度）（1是,0否）")
    private Integer fever;
    @ApiModelProperty(value = "其它症状（咳嗽、头痛、胸闷、呼吸困难、。。。参考已有的）")
    private String symptom;
    @ApiModelProperty(value = "一起返回的家属（父母、爱人、孩子、孙子女、亲属）")
    private String backTogether;
    @ApiModelProperty(value = "家属身体状况（0正常，1异常）")
    private Integer familySymptom;
    @ApiModelProperty(value = "是否向所在社区居委会登记报到（1是,0否）")
    private Integer reportCommittee;
    @ApiModelProperty(value = "外地返回是否做自我居家隔离14天（1居家隔离完成、2隔离中、3未隔离）")
    private Integer fourteenDayIsolation;
    @ApiModelProperty(value = "其他需要报告的情况")
    private String remark;
    @ApiModelProperty(value = "当前所在省")
    private String currentProvince;
    @ApiModelProperty(value = "市（当前所在地）")
    private String currentCity;
    @ApiModelProperty(value = "区/县（当前所在地）")
    private String currentCounty;
    @ApiModelProperty(value = "街道/乡/镇（当前所在地）")
    private String currentCountry;
    @ApiModelProperty(value = "社区/村（当前所在地）")
    private String currentVillage;
    @ApiModelProperty(value = "小区编码")
    private String communityCode;
    @ApiModelProperty(value = "小区（详细地址）")
    private String community;
    @ApiModelProperty(value = "楼栋（详细地址）")
    private String building;
    @ApiModelProperty(value = "单元（详细地址）")
    private String unit;
    @ApiModelProperty(value = "楼层")
    private String floor;
    @ApiModelProperty(value = "房号（详细地址）")
    private String roomNumber;
    @ApiModelProperty(value = "上报时间")
    private Date createTime;
    @ApiModelProperty(value = "人群类型（0:确诊，1:疑似，2:密接）")
    private Integer personnelType;
    @ApiModelProperty(value = "解决隔离时间")
    private String relieveDate;
    @ApiModelProperty(value = "车次或航班号")
    private String trainNumber;
    @ApiModelProperty(value = "去湖北时间")
    private String beenHubeiDate;
    @ApiModelProperty(value = "离开湖北时间")
    private String leaveHubeiDate;
    @ApiModelProperty(value = "接触武汉人信息")
    private String peopleWuhan;
    @ApiModelProperty(value = "接触湖北人信息")
    private String peopleHubei;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDeptmentCode() {
        return deptmentCode;
    }

    public void setDeptmentCode(String deptmentCode) {
        this.deptmentCode = deptmentCode == null ? null : deptmentCode.trim();
    }

    public String getDeptmentName() {
        return deptmentName;
    }

    public void setDeptmentName(String deptmentName) {
        this.deptmentName = deptmentName == null ? null : deptmentName.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(Integer dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate == null ? null : postDate.trim();
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate == null ? null : leaveDate.trim();
    }

    public Integer getLeaveHabitation() {
        return leaveHabitation;
    }

    public void setLeaveHabitation(Integer leaveHabitation) {
        this.leaveHabitation = leaveHabitation;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity == null ? null : toCity.trim();
    }

    public Integer getBack() {
        return back;
    }

    public void setBack(Integer back) {
        this.back = back;
    }

    public String getCurrentCityName() {
        return currentCityName;
    }

    public void setCurrentCityName(String currentCityName) {
        this.currentCityName = currentCityName == null ? null : currentCityName.trim();
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate == null ? null : backDate.trim();
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public Integer getBeenHubei() {
        return beenHubei;
    }

    public void setBeenHubei(Integer beenHubei) {
        this.beenHubei = beenHubei;
    }

    public Integer getPassHubei() {
        return passHubei;
    }

    public void setPassHubei(Integer passHubei) {
        this.passHubei = passHubei;
    }

    public String getPlanBackDate() {
        return planBackDate;
    }

    public void setPlanBackDate(String planBackDate) {
        this.planBackDate = planBackDate == null ? null : planBackDate.trim();
    }

    public Integer getTouchHubei() {
        return touchHubei;
    }

    public void setTouchHubei(Integer touchHubei) {
        this.touchHubei = touchHubei;
    }

    public Integer getFourteenDayTouchWuhan() {
        return fourteenDayTouchWuhan;
    }

    public void setFourteenDayTouchWuhan(Integer fourteenDayTouchWuhan) {
        this.fourteenDayTouchWuhan = fourteenDayTouchWuhan;
    }

    public Integer getFourteenDayTouchHubei() {
        return fourteenDayTouchHubei;
    }

    public void setFourteenDayTouchHubei(Integer fourteenDayTouchHubei) {
        this.fourteenDayTouchHubei = fourteenDayTouchHubei;
    }

    public Integer getFever() {
        return fever;
    }

    public void setFever(Integer fever) {
        this.fever = fever;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getBackTogether() {
        return backTogether;
    }

    public void setBackTogether(String backTogether) {
        this.backTogether = backTogether == null ? null : backTogether.trim();
    }

    public Integer getFamilySymptom() {
        return familySymptom;
    }

    public void setFamilySymptom(Integer familySymptom) {
        this.familySymptom = familySymptom;
    }

    public Integer getReportCommittee() {
        return reportCommittee;
    }

    public void setReportCommittee(Integer reportCommittee) {
        this.reportCommittee = reportCommittee;
    }

    public Integer getFourteenDayIsolation() {
        return fourteenDayIsolation;
    }

    public void setFourteenDayIsolation(Integer fourteenDayIsolation) {
        this.fourteenDayIsolation = fourteenDayIsolation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCurrentProvince() {
        return currentProvince;
    }

    public void setCurrentProvince(String currentProvince) {
        this.currentProvince = currentProvince == null ? null : currentProvince.trim();
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity == null ? null : currentCity.trim();
    }

    public String getCurrentCounty() {
        return currentCounty;
    }

    public void setCurrentCounty(String currentCounty) {
        this.currentCounty = currentCounty == null ? null : currentCounty.trim();
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry == null ? null : currentCountry.trim();
    }

    public String getCurrentVillage() {
        return currentVillage;
    }

    public void setCurrentVillage(String currentVillage) {
        this.currentVillage = currentVillage == null ? null : currentVillage.trim();
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode == null ? null : communityCode.trim();
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(Integer personnelType) {
        this.personnelType = personnelType;
    }

    public String getRelieveDate() {
        return relieveDate;
    }

    public void setRelieveDate(String relieveDate) {
        this.relieveDate = relieveDate == null ? null : relieveDate.trim();
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber == null ? null : trainNumber.trim();
    }

    public String getBeenHubeiDate() {
        return beenHubeiDate;
    }

    public void setBeenHubeiDate(String beenHubeiDate) {
        this.beenHubeiDate = beenHubeiDate == null ? null : beenHubeiDate.trim();
    }

    public String getLeaveHubeiDate() {
        return leaveHubeiDate;
    }

    public void setLeaveHubeiDate(String leaveHubeiDate) {
        this.leaveHubeiDate = leaveHubeiDate == null ? null : leaveHubeiDate.trim();
    }

    public String getPeopleWuhan() {
        return peopleWuhan;
    }

    public void setPeopleWuhan(String peopleWuhan) {
        this.peopleWuhan = peopleWuhan == null ? null : peopleWuhan.trim();
    }

    public String getPeopleHubei() {
        return peopleHubei;
    }

    public void setPeopleHubei(String peopleHubei) {
        this.peopleHubei = peopleHubei == null ? null : peopleHubei.trim();
    }
}