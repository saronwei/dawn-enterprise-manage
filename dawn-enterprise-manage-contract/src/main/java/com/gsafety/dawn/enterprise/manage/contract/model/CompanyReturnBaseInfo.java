package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * The type Company return base info.
 *
 * @ClassName：CompanyReturnBaseInfo
 * @Description：企业信息返回model
 * @Author：ChenCong
 * @Date：Created in 2020/2/13 2:21
 */
public class CompanyReturnBaseInfo {
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 返京人数（累积）
     */
    @ApiModelProperty(value = "返京人数（累积）")
    private Integer returnBeiJingTotal;
    /**
     * 途径/到达湖北（已返京）
     */
    @ApiModelProperty(value = "途径/到达湖北（已返京）")
    private Integer accrossHuBeiTotal;
    /**
     * 解除隔离（今日解除隔离）
     */
    @ApiModelProperty(value = "解除隔离（今日解除隔离）")
    private Integer disisolationTotal;
    /**
     * 上岗人数（今日办公情况（现场））
     */
    @ApiModelProperty(value = "上岗人数（今日办公情况（现场））")
    private Integer workingTotal;

    /**
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets total 1.
     *
     * @return the total 1
     */
    public Integer getReturnBeiJingTotal() {
        return returnBeiJingTotal;
    }

    /**
     * Sets total 1.
     *
     * @param returnBeiJingTotal the total 1
     */
    public void setReturnBeiJingTotal(Integer returnBeiJingTotal) {
        this.returnBeiJingTotal = returnBeiJingTotal;
    }

    /**
     * Gets total 2.
     *
     * @return the total 2
     */
    public Integer getAccrossHuBeiTotal() {
        return accrossHuBeiTotal;
    }

    /**
     * Sets total 2.
     *
     * @param accrossHuBeiTotal the total 2
     */
    public void setAccrossHuBeiTotal(Integer accrossHuBeiTotal) {
        this.accrossHuBeiTotal = accrossHuBeiTotal;
    }

    /**
     * Gets total 3.
     *
     * @return the total 3
     */
    public Integer getDisisolationTotal() {
        return disisolationTotal;
    }

    /**
     * Sets total 3.
     *
     * @param disisolationTotal the total 3
     */
    public void setDisisolationTotal(Integer disisolationTotal) {
        this.disisolationTotal = disisolationTotal;
    }

    /**
     * Gets total 4.
     *
     * @return the total 4
     */
    public Integer getWorkingTotal() {
        return workingTotal;
    }

    /**
     * Sets total 4.
     *
     * @param workingTotal the total 4
     */
    public void setWorkingTotal(Integer workingTotal) {
        this.workingTotal = workingTotal;
    }
}
