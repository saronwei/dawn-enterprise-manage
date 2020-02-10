package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportHistoryModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.java.common.page.PageBean;

import java.util.List;

/**
 * The interface Enterprise upload history service.
 */
public interface EnterpriseReportHistoryService {
    /**
     * Pag query list.
     *
     * @param page     the page
     * @param pageSize the page size
     * @return the list
     */
    PageBean<EnterpriseReportHistoryModel> getEnterpriseReportHistoryByPage(int page, int pageSize);

    /**
     * 新增/修改企业上报历史
     * @param model
     * @return
     */
    EnterpriseReportHistoryModel saveEnterpriseReportHistoryByHistotyModel(EnterpriseReportHistoryModel model);

    /**
     * 填写企业上报历史
     * @param model
     * @return
     */
    EnterpriseReportHistoryModel saveEnterpriseReportHistoryByReportModel(EnterpriseReportModel model);

    /**
     * 根据企业上报Id删除上报记录
     * @param id
     * @return
     */
     boolean delEnterpriseUploadHistoryById(String id);

    /**
     * 根据Id查企业上报记录
     * @param id
     * @return
     */
    public EnterpriseReportHistoryModel findEnterpriseUploadHistoryById(String id);
}
