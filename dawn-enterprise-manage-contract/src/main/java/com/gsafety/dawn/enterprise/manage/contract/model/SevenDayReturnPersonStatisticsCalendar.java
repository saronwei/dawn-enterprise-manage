package com.gsafety.dawn.enterprise.manage.contract.model;

import java.util.Map;

/**
 * @ClassName：SevenDayReturnPersonStatisticsCalendar
 * @Description：未来七天返岗人员统计日历
 * @Author：ChenCong
 * @Date：Created in 2020/2/12 20:20
 */
public class SevenDayReturnPersonStatisticsCalendar {

    private Boolean success;
    private String code;
    private String msg;
    private Map<String, Object> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
