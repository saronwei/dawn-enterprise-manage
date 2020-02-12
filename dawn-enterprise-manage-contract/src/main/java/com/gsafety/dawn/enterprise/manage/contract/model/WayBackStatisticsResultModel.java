package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName：WayBackStatisticsResultModel
 * @Description： 返程方式统计结果
 * @Author：ChenCong
 * @Date：Created in 2020/2/12 20:12
 */
public class WayBackStatisticsResultModel {
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String status;
    /**
     * 总数
     */
    @ApiModelProperty(value = "总数")
    private Integer total;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
