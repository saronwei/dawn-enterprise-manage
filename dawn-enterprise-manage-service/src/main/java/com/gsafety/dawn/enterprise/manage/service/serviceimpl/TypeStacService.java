package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TypeStacService {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Map typestac() {
        return jdbcTemplate.queryForMap("select SUM(COALESCE(CAST(confirm_num AS INTEGER), 0)) as 确诊人数, SUM(COALESCE(CAST(suspect_num AS INTEGER ), 0 ) ) 疑似人数, \n" +
                "SUM(COALESCE(CAST(quarantine_num AS INTEGER ), 0 ) ) as 隔离人数,\n" +
                "        SUM(COALESCE(CAST(contact_num AS INTEGER ), 0 ) ) as 密接人数\n" +
                "from b_enterprise_report", new HashMap<>());
    }

    public Map typestacPerson() {
        return jdbcTemplate.queryForMap("select SUM(COALESCE(CAST(insure_num AS INTEGER), 0)) as totals, SUM(COALESCE(CAST(arrival_num AS INTEGER ), 0 ) ) as returns from h_enterprise_report"
                , new HashMap<>());
    }

    public Map<String, Object> typestacEnterpriseStaffTotal(String companyId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", 10);
        String sql = "select SUM(COALESCE(CAST(total_num AS INTEGER), 0)) as totals, " +
                " SUM(COALESCE(CAST(arrival_num AS INTEGER ), 0 ) ) as returns " +
                " SUM(COALESCE(CAST(local_num AS INTEGER ), 0 ) ) as localReturns " +
                " SUM(COALESCE(CAST(other_num AS INTEGER ), 0 ) ) as outReturns " +
                " from e_company_report_info" +
                " WHERE on_work_in_total=:companyId";
        return jdbcTemplate.queryForMap(sql, paramMap);
    }

}