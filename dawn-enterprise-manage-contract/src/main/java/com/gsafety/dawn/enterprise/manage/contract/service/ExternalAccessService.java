package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseCriteria;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportImportantPersonStat;
import com.gsafety.dawn.enterprise.manage.contract.model.ReportedPersonInfoModel;

import java.util.List;

public interface ExternalAccessService {
    // 所有已填报人员信息
    List<ReportedPersonInfoModel> getReportedPersonsInfo();
    // 重点关注人员统计
    List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics(EnterpriseCriteria enterpriseCriteria);
    // 重点关注人员统计2
    List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics2(EnterpriseCriteria enterpriseCriteria);
}
