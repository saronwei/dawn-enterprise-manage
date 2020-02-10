package com.gsafety.dawn.enterprise.manage.contract.model;

public class EnterpriseReportImportantPersonStat {
    // 人员状态
    private String status;
    // 数量
    private Integer total;

    // 人员状态名称
    private String name;
    // 数量
    private Integer count;
    private Integer value;
    private boolean selected;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
