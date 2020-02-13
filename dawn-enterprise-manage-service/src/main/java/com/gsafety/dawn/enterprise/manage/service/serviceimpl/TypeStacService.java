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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.util.*;

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

    public Map getEnterpriseStac(String[] companyName) {
        String areaId = this.getParkIdByName(companyName);
        if(areaId == null) {
            return null;
        }
        String sql = "select COUNT(*) as enterpriseTotals, SUM(COALESCE(CAST(staff_num AS INTEGER ), 0)) as enterprisePersonTotals from be_company where area_id=:areaId";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("areaId", areaId);
        return jdbcTemplate.queryForMap(sql,paramMap);
    }

    public String getParkIdByName(String[] companyName) {
        String areaid = null;
        String sql = "select area_id as parkId from be_company where name in (:companyName)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("companyName", Arrays.asList(companyName));
        List<String> list = jdbcTemplate.queryForList(sql, paramMap, String.class);
        if(!CollectionUtils.isEmpty(list)) {
            areaid = list.get(0);
        }
        return areaid;
    }

    public String comps(String companyId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        List<Map<String, Object>> ll =  jdbcTemplate.queryForList("select a.company_id as companyId from be_company a where a.area_id = (select area_id from be_company where company_id = :companyId)", paramMap);
        List<String> ss = new ArrayList<>();
        for(Map<String, Object> mm : ll) {
            ss.add((String)mm.get("companyId"));
        }
        return StringUtils.arrayToCommaDelimitedString(ss.toArray(new String[0]));
    }

    public int staffTotals(String companyId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        List<Map<String, Object>> ll =  jdbcTemplate.queryForList("select staff_num from be_company where company_id = :companyId", paramMap);
        List<String> ss = new ArrayList<>();
        int tts = 0;
        if(!CollectionUtils.isEmpty(ll)) {
            for(Map<String, Object> mm : ll) {
                tts = Integer.parseInt(String.valueOf(mm.get("staff_num")));
            }
        }
        return tts;
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
        " WHEN '消杀区域' THEN 'eliminates'"+
        " WHEN '隔离' THEN 'isolates'"+
        " WHEN '体温检测' THEN 'tempchecks'"+
        " WHEN '口罩发放' THEN 'masks'"+
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
        String url = this.mobilHost + "/api/enterprise/report/queryReturnWorkNum";
        Map<String, Object> paramMap = new HashMap<>();
        if(!StringUtils.isEmpty(companyId)) {
            url += "?enterpriseInfo=" + companyId;
        }
        HttpEntity<Map> entity = new HttpEntity<>(paramMap);
        List<Map<String, Object>> rList = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<Map<String, Object>>>>(){}).getBody().getData();
        paramMap.clear();
        for (Map<String, Object> mm : rList) {
            if ("远程办公人数".equals(mm.get("status"))) {
                paramMap.put("remoteWorks", mm.get("total"));
            }
            if ("现场办公人数".equals(mm.get("status"))) {
                paramMap.put("localWorks", mm.get("total"));
            }
            if ("返岗人数".equals(mm.get("status"))) {
                paramMap.put("returns", mm.get("total"));
            }
            if ("外地返岗人数".equals(mm.get("status"))) {
                paramMap.put("outReturns", mm.get("total"));
            }
            if ("本地返岗人数".equals(mm.get("status"))) {
                paramMap.put("localReturns", mm.get("total"));
            }
        }
        if(!StringUtils.isEmpty(companyId)) {
            String[] ids  = companyId.split(",");
            if(ids.length > 0) {
                Map<String, Object> totalMap = this.getEnterpriseStac(Arrays.asList(ids[0]).toArray(new String[0]));
                paramMap.put("totals", totalMap==null ? 0 : totalMap.get("enterprisePersonTotals"));
            } else {
                paramMap.put("totals", this.staffTotals(ids[0]));
            }
        } else {
            paramMap.put("totals", 0);
        }

        int totals = Integer.parseInt(String.valueOf(paramMap.get("totals")));
        int returns = Integer.parseInt(String.valueOf(paramMap.get("returns")));
        String prencent = "0.00%";
        if(totals > 0) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            prencent = numberFormat.format((float) returns / (float) totals * 100) + "%";
        }
        paramMap.put("precents", prencent);
        return paramMap;
    }

    /**
     * healths infects doubts closes colds fevers
     * 健康人数，确诊/感染人数，疑似人数，密接人数，感冒人数、发热人数
     * @param companyId
     * @return
     */
    public Map<String, Object> typestacEnterpriseStaffHealthTotal(String companyId) {
        String url = this.mobilHost + "/api/enterprise/report/returnPersonHealthInfo";
        Map<String, Object> paramMap = new HashMap<>();
        if(!StringUtils.isEmpty(companyId)) {
            url += "?enterpriseInfo=" + companyId;
        }
        HttpEntity<Map> entity = new HttpEntity<>(paramMap);
        List<Map<String, Object>> rList = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<Map<String, Object>>>>(){}).getBody().getData();
        paramMap.clear();
        for (Map<String, Object> mm : rList) {
            if("确诊/感染人数".equals(mm.get("status"))) {
                paramMap.put("infects", mm.get("total"));
            }
            if("疑似人数".equals(mm.get("status"))) {
                paramMap.put("doubts", mm.get("total"));
            }
            if("密接人数".equals(mm.get("status"))) {
                paramMap.put("closes", mm.get("total"));
            }
            if("健康人数".equals(mm.get("status"))) {
                paramMap.put("healths", mm.get("total"));
            }
            if("发热人数".equals(mm.get("status"))) {
                paramMap.put("fevers", mm.get("total"));
            }
            if("感冒人数".equals(mm.get("status"))) {
                paramMap.put("colds", mm.get("total"));
            }
        }
        return paramMap;
    }

}