package com.gsafety.dawn.enterprise.manage.contract.model;

import java.util.List;

public class CompanyReportQueryInfo {
    private List<String> companyIds;
    private String keyWord;
    private Integer currentPage;
    private Integer pageSize;
    /**
     * 排序字符串(如: filedA,desc)
     */
    List<String> sorts;

    public List<String> getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(List<String> companyIds) {
        this.companyIds = companyIds;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
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

    public List<String> getSorts() {
        return sorts;
    }

    public void setSorts(List<String> sorts) {
        this.sorts = sorts;
    }
}