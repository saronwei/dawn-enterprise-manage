package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName：CompanyPageSearchResult
 * @Description：分页查询结果
 * @Author：ChenCong
 * @Date：Created in 2020/2/13 2:48
 */
public class CompanyPageSearchResult {
    /**
     * 企业基础信息集合
     */
    @ApiModelProperty(value = "企业基础信息集合")
    private List<CompanyReturnBaseInfo> infoList;
    /**
     * 企业总条数
     */
    @ApiModelProperty(value = "企业总条数")
    private Integer total;

    public List<CompanyReturnBaseInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<CompanyReturnBaseInfo> infoList) {
        this.infoList = infoList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
