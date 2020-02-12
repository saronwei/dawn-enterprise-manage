package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseCriteria;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportImportantPersonStat;
import com.gsafety.dawn.enterprise.manage.contract.model.ReportedPersonInfoModel;

import java.util.List;
import java.util.Map;

public interface ExternalAccessService {
    // 所有已填报人员信息
    List<ReportedPersonInfoModel> getReportedPersonsInfo();
    // 重点关注人员统计
    List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics(EnterpriseCriteria enterpriseCriteria);
    // 返岗人员接触史统计
    List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics2(EnterpriseCriteria enterpriseCriteria);
    // 隔离情况
    List<EnterpriseReportImportantPersonStat> getIsolationStatistics(EnterpriseCriteria enterpriseCriteria);
    // 企业总体情况统计
    Map getEnterpriseStac(String companyId);
    // 办公情况统计
    List<EnterpriseReportImportantPersonStat> getOfficeStac(String areaId);
    // 园区情况统计
    Map<String,Object> getAreaStac();
}
