package com.gsafety.dawn.enterprise.manage.service.serviceimpl.cg;

import com.gsafety.dawn.enterprise.manage.contract.model.cg.StatisticModel;
import com.gsafety.dawn.enterprise.manage.contract.service.cm.PersonReportStatisticService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonReportStatisticServiceImpl implements PersonReportStatisticService {

    @Override
    public Map<String, Object> countDiagnosisPerson(StatisticModel statisticModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("确诊人员", 2);
        map.put("疑似人员", 8);
        map.put("发热人员", 10);
        map.put("其他人员", 30);
        return map;
    }

    @Override
    public Map<String, Object> countReportStatusPerson(StatisticModel statisticModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("已填报", 10);
        map.put("未填报", 40);
        return map;
    }

    @Override
    public Map<String, Object> countOnWorkPerson(StatisticModel statisticModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("report", 18);
        map.put("unReport", 40);
        return map;
    }

    @Override
    public Map<String, Object> countFocuePerson(StatisticModel statisticModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("report", 18);
        map.put("unReport", 40);
        return map;
    }
}
