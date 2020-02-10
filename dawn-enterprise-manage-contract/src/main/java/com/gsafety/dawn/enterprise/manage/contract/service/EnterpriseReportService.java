package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportQueryInfo;
import com.gsafety.java.common.page.PageBean;

public interface EnterpriseReportService {
    EnterpriseReportModel saveEnterpriseReport(EnterpriseReportModel enterpriseReportModel);

    PageBean<EnterpriseReportModel> findByQueryInfo(EnterpriseReportQueryInfo queryInfo);
}
