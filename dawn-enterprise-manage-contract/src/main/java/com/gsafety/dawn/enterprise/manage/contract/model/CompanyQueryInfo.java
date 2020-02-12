package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName：CompanyQueryInfo
 * @Description：分页查询企业信息条件
 * @Author：ChenCong
 * @Date：Created in 2020/2/13 2:36
 */
public class CompanyQueryInfo {
    /**
     * 园区id
     */
    @ApiModelProperty(value = "园区id")
    private String areaId;
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页（默认从第0页开始）")
    private int pageIndex = 0;
    /**
     * 每页显示条数
     */
    @ApiModelProperty(value = "每页显示条数（默认10条）")
    private int pageSize = 10;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
