package com.gsafety.dawn.enterprise.manage.contract.model;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

/**
 * The type Enterprise info query info.
 */
public class EnterpriseInfoQueryInfo {
    private String name;
    private String areaName;
    private Integer currentPage;
    private Integer pageSize;

    /**
     * Gets area name.
     *
     * @return the area name
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets area name.
     *
     * @param areaName the area name
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * Gets current page.
     *
     * @return the current page
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets current page.
     *
     * @param currentPage the current page
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
