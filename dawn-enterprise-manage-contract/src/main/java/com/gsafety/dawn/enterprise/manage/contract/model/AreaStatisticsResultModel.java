package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName：AreaStatisticsResultModel
 * @Description： 区域统计返回结果
 * @Author：ChenCong
 * @Date：Created in 2020/2/12 20:04
 */
public class AreaStatisticsResultModel {
    /**
     * 已返工数量
     */
    @ApiModelProperty(value = "已返工数量")
    private Integer total1;
    /**
     * 解除隔离返岗员工数量
     */
    @ApiModelProperty(value = "解除隔离返岗员工数量")
    private Integer total2;

    public AreaStatisticsResultModel(String status, Integer total1, Integer total2) {
        this.total1 = total1;
        this.total2 = total2;
    }

    public AreaStatisticsResultModel() {
    }

    public Integer getTotal1() {
        return total1;
    }

    public void setTotal1(Integer total1) {
        this.total1 = total1;
    }

    public Integer getTotal2() {
        return total2;
    }

    public void setTotal2(Integer total2) {
        this.total2 = total2;
    }
}
