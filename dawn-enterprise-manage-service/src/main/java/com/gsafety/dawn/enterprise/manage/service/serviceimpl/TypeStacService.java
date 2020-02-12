package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.google.common.collect.Lists;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseCriteria;
import com.gsafety.dawn.enterprise.manage.contract.model.Result;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeStacService {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ExternalAccessService externalAccessService;

    @Value("${mobile.host}")
    private String mobilHost;

    public String comps(String companyId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        List<Map<String, Object>> ll =  jdbcTemplate.queryForList("select a.company_id as companyId from be_company a where a.area_id = (select area_id from be_company where company_id = :companyId)", paramMap);
        List<String> ss = new ArrayList<>();
        for(Map<String, Object> mm : ll) {
            ss.add((String)mm.get("companyId"));
        }
        return StringUtils.arrayToCommaDelimitedString(ll.toArray(new String[0]));
    }

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
    /**
     * eliminates isolates tempchecks masks
     * 消杀，隔离，体温检测，发放口罩
     * @return
     */
    public Map<String, Object> typestacGovPreventionMeasures() {
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "SELECT (CASE b.measure_id"+
        " WHEN 'a1' THEN 'eliminates'"+
        " WHEN 'a2' THEN 'isolates'"+
        " WHEN 'a3' THEN 'tempchecks'"+
        " WHEN 'a4' THEN 'masks'"+
        " END) as types, count(b.company_id) as totals"+
        " FROM re_company_measure b"+
        " group by b.measure_id";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, paramMap);
        paramMap.clear();
        for(Map<String, Object> map : list) {
            paramMap.put((String)map.get("types"), map.get("totals"));
        }
        List<String> aa = Lists.newArrayList("eliminates", "isolates", "tempchecks", "masks");
        for(String ss : aa) {
            if(paramMap.containsKey(ss)) {
                continue;
            }
            paramMap.put(ss, 0);
        }
        return paramMap;
    }

    /**
     * totals returns precents localReturns outReturns localWorks remoteWorks
     * 企业总人数、返岗人数，返岗比例，本地返岗数，外地返岗数，现场办公人数，远程办公人数
     * @param companyId
     * @return
     */
    public Map<String, Object> typestacEnterpriseStaffTotal(String companyId) {
        String url = this.mobilHost + "";
        Map<String, Object> paramMap = new HashMap<>();
        if(StringUtils.isEmpty(companyId)) {
            String comps = this.comps(companyId);
            paramMap.put("companyIds", comps);
        }
        HttpEntity<Map> entity = new HttpEntity<>(paramMap);
        Map<String, Object> rs = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<Map>>(){}).getBody().getData();
        paramMap.clear();
        if(!StringUtils.isEmpty(companyId)) {
            Map<String, Object> totalMap = externalAccessService.getEnterpriseStac(companyId);
            paramMap.put("totals", totalMap.get("enterprisePersonTotals"));
        }
        paramMap.put("returns", rs.get(""));
        paramMap.put("localReturns", rs.get(""));
        paramMap.put("outReturns", rs.get(""));
        paramMap.put("localWorks", rs.get(""));
        paramMap.put("remoteWorks", rs.get(""));
        int totals = Integer.parseInt(String.valueOf(rs.get("totals")));
        int returns = Integer.parseInt(String.valueOf(rs.get("returns")));
        String prencent = "0.00%";
        if(totals > 0) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            prencent = numberFormat.format((float) returns / (float) totals * 100) + "%";
        }
        rs.put("precents", prencent);
        return paramMap;
    }

    /**
     * healths infects doubts closes colds fevers
     * 健康人数，确诊/感染人数，疑似人数，密接人数，感冒人数、发热人数
     * @param companyId
     * @return
     */
    public Map<String, Object> typestacEnterpriseStaffHealthTotal(String companyId) {
        String url = this.mobilHost + "";
        Map<String, Object> paramMap = new HashMap<>();
        if(StringUtils.isEmpty(companyId)) {
            String comps = this.comps(companyId);
            paramMap.put("companyIds", comps);
        }
        HttpEntity<Map> entity = new HttpEntity<>(paramMap);
        Map<String, Object> rs = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<Map>>(){}).getBody().getData();
        paramMap.clear();
        paramMap.put("healths", rs.get(""));
        paramMap.put("infects", rs.get(""));
        paramMap.put("doubts", rs.get(""));
        paramMap.put("closes", rs.get(""));
        paramMap.put("colds", rs.get(""));
        paramMap.put("fevers", rs.get(""));
        return paramMap;
    }

}