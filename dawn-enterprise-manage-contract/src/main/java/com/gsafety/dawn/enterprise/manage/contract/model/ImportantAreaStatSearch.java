package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName：QueryInfo
 * @Description：
 * @Author：ChenCong
 * @Date：Created in 2020/2/12 20:44
 */
public class ImportantAreaStatSearch {
    /**
     * 企业id或企业名称,用逗号隔开
     */
    @ApiModelProperty(value = "企业id或企业名称,用逗号隔开")
    private String enterpriseInfo;
    /**
     * 疫区类型（0：重点区域、1：非重点区域）
     */
    @ApiModelProperty(value = "疫区类型（0：重点区域、1：非重点区域）")
    private String areaType;

    public String getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(String enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }
}
