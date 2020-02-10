package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public class EnterpriseReportQueryInfo {
    private String enterpriseName;
    private Integer currentPage = 0;
    private Integer pageSize = 10;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
