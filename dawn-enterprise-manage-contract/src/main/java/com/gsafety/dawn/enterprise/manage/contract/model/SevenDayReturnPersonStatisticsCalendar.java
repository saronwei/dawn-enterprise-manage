package com.gsafety.dawn.enterprise.manage.contract.model;

import com.gsafety.dawn.enterprise.manage.contract.model.enums.Week;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName：SevenDayReturnPersonStatisticsCalendar
 * @Description：未来七天返岗人员统计日历
 * @Author：ChenCong
 * @Date：Created in 2020/2/12 20:20
 */
public class SevenDayReturnPersonStatisticsCalendar {
    /**
     * 返回状态码
     */
    @ApiModelProperty(value = "返回状态码")
    private String status;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date date;
    /**
     * 星期
     */
    @ApiModelProperty(value = "星期")
    private Week week;
    /**
     * 预计当天返岗人数
     */
    @ApiModelProperty(value = "预计当天返岗人数")
    private Integer todayTotal;
    /**
     * 预计七天返岗总数
     */
    @ApiModelProperty(value = "预计七天返岗总数")
    private Integer totalCount;

    public SevenDayReturnPersonStatisticsCalendar(String status, Date date, Week week, Integer todayTotal, Integer totalCount) {
        this.status = status;
        this.date = date;
        this.week = week;
        this.todayTotal = todayTotal;
        this.totalCount = totalCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Integer getTodayTotal() {
        return todayTotal;
    }

    public void setTodayTotal(Integer todayTotal) {
        this.todayTotal = todayTotal;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
