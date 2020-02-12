package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportModel;
import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportQueryInfo;
import com.gsafety.java.common.page.PageBean;

public interface CompanyReportService {
    CompanyReportModel findByCompanyId(String companyId);

    CompanyReportModel saveCompanyReport(CompanyReportModel companyReportModel);

    CompanyReportModel updateCompanyReport(CompanyReportModel companyReportModel);

    PageBean<CompanyReportModel> findByQueryInfo(CompanyReportQueryInfo companyReportQueryInfo);
}
