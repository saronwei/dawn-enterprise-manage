package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.common.util.StringUtil;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseInfoQueryInfo;
import com.gsafety.java.common.page.PageBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface EnterpriseInfoService {
    /**
     * 按Id查询企业基本信息
     * @param id
     * @return
     */
    EnterpriseInfoModel getEnterpriseInfoById(String id);

    /**
     * 按租户Id查询企业基本信息
     * @param antId
     * @return
     */
    EnterpriseInfoModel getEnterpriseInfoByAntId(String antId);

    /**
     * 企业基本信息按条件分页查询
     * @param queryInfo
     * @return
     */
    PageBean<EnterpriseInfoModel> getEnterpriseInfoModelByPage(EnterpriseInfoQueryInfo queryInfo);

    /**
     * 新增/修改企业基本信息
     * @param model
     * @return
     */
    EnterpriseInfoModel saveEnterpriseInfoModel(EnterpriseInfoModel model);

    /**
     * 根据企业Id删除
     * @param id
     * @return
     */
    boolean delEnterpriseInfoById(String id);
}
