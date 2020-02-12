package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.*;

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
    List<Map<String,Object>> getAreaStac();

    List<EnterpriseReportImportantPersonStat> getOfficeStac();


    /**
     * 区域统计
     * @param query 查询条件
     * @return 区域统计结果
     */
    AreaStatisticsResultModel getImportantAreaStatistics(ImportantAreaStatSearch query);

    /**
     * 返程方式统计
     * @param enterpriseInfo 查询条件
     * @return 返程方式统计结果
     */
    List<WayBackStatisticsResultModel> getWayBackStatistics(String enterpriseInfo);

    /**
     * 未来七天返岗人员统计日历
     * @param enterpriseCriteria 查询条件
     * @return 未来七天返岗人员统计日历统计结果
     */
    SevenDayReturnPersonStatisticsCalendar getSevenDayReturnPersonStatisticsCalendar(EnterpriseCriteria enterpriseCriteria);

}
