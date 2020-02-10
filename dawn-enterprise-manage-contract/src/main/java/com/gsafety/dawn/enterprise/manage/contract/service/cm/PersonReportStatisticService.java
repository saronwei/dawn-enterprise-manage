package com.gsafety.dawn.enterprise.manage.contract.service.cm;

import com.gsafety.dawn.enterprise.manage.contract.model.cg.StatisticModel;

import java.util.Map;

public interface PersonReportStatisticService {

    /**
     * 诊断状态统计
     * @param statisticModel
     * @return
     */
    Map<String, Object> countDiagnosisPerson(StatisticModel statisticModel);

    /**
     * 填报状态统计
     * @param statisticModel
     * @return
     */
    Map<String, Object> countReportStatusPerson(StatisticModel statisticModel);

    /**
     * 到岗情况统计
     * @param statisticModel
     * @return
     */
    Map<String, Object> countOnWorkPerson(StatisticModel statisticModel);

    /**
     * 重点人员统计
     * @param statisticModel
     * @return
     */
    Map<String, Object> countFocuePerson(StatisticModel statisticModel);



}
