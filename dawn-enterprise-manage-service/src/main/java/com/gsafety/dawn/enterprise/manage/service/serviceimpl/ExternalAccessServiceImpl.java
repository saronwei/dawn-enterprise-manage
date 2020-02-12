package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.manage.contract.model.*;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExternalAccessServiceImpl implements ExternalAccessService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private TypeStacService typeStacService;

    @Override
    public List<ReportedPersonInfoModel> getReportedPersonsInfo() {
        // todo 调用手机端接口
        return null;
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics(EnterpriseCriteria enterpriseCriteria) {
        // todo 调用手机端接口
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = "http://39.105.209.108:8090/api/enterprise/report/importantPersonStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url,HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>(){}).getBody().getData();
//        List<EnterpriseReportImportantPersonStat> results = new ArrayList<>();
        for(EnterpriseReportImportantPersonStat personStaticsModel : result) {
            personStaticsModel.setName(personStaticsModel.getStatus());
            personStaticsModel.setCount(personStaticsModel.getTotal());
            personStaticsModel.setValue(personStaticsModel.getTotal());
            personStaticsModel.setSelected(false);
    }
        return result;
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics2(EnterpriseCriteria enterpriseCriteria) {
        // todo 调用手机端接口
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = "http://39.105.209.108:8090/api/enterprise/report/importantPersonStat2";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url,HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>(){}).getBody().getData();
        return result;
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getIsolationStatistics(EnterpriseCriteria enterpriseCriteria) {
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = "http://39.105.209.108:8090/api/enterprise/report/isolationPersonStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url,HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>(){}).getBody().getData();
        return result;
    }

    @Override
    public Map getEnterpriseStac(String companyId) {
        String areaId = this.getParkId(companyId);
        String sql = "select COUNT(*) as enterpriseTotals, SUM(COALESCE(CAST(staff_num AS INTEGER ), 0)) as enterprisePersonTotals from be_company where area_id=:areaId";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("areaId", areaId);
        return jdbcTemplate.queryForMap(sql,paramMap);
    }

    // 办公情况统计用
    @Override
    public List<EnterpriseReportImportantPersonStat> getOfficeStac() {
        String ids = this.typeStacService.comps("area-0005"); // todo 传企业id
        String names = this.getCompanyNames("area-0005");
        EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
        enterpriseCriteria.setEnterpriseCode(ids);
        enterpriseCriteria.setEnterpriseName(names);
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = "http://39.105.209.108:8090/api/enterprise/report/workTypeStat"; // todo 手机端
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url,HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>(){}).getBody().getData();
        return result;
    }

    public String getParkId(String companyId) {
        String sql = "select area_id as parkId from be_company where company_id=:companyId";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("companyId", companyId);
        return jdbcTemplate.queryForObject(sql,paramMap,String.class);
    }

    public String getCompanyNames(String companyId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        List<Map<String, Object>> ll =  jdbcTemplate.queryForList("select a.name as companyName from be_company a where a.area_id = (select area_id from be_company where company_id = :companyId)", paramMap);
        List<String> ss = new ArrayList<>();
        for(Map<String, Object> mm : ll) {
            ss.add((String)mm.get("companyName"));
        }
        return StringUtils.arrayToCommaDelimitedString(ll.toArray(new String[0]));
    }
    // 查询园区表
    public List<String> getAreaIds() {
        String sql = "select area_id as areaId from be_area";
        return jdbcTemplate.queryForList(sql, new HashMap<>(),String.class);
    }
    // 获取所有园区的所有企业id
    public List<String> getEnterpriseIds() {
        List<String> areaList = this.getAreaIds();
        List<String> companyIdList = new ArrayList<>();
        for(String areaId: areaList) {
            String sql = "select company_id as companyId from be_company where area_id=:areaId";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("areaId", areaId);
            List<String> list = jdbcTemplate.queryForList(sql,paramMap,String.class);
            String companyIds = "";
            for (String str: list) {
                companyIds += str + ",";
            }
            companyIdList.add(companyIds);
        }

        return companyIdList;
    }

    // 获取园区情况统计
    public Map<String,Object> getAreaStac() {
        Map<String, Object> paramMap = new HashMap<>();
        List<String> companyList = this.getEnterpriseIds();
        Integer viaNum = 0;
        for(String ids: companyList) {
            Map<String,Object> staffHealthTotal= typeStacService.typestacEnterpriseStaffHealthTotal(ids);
            Map<String, Object> returnStaffTotal = typeStacService.typestacEnterpriseStaffTotal(ids);
            paramMap.put("colds", staffHealthTotal.get("colds"));// 感冒人数
            paramMap.put("fevers", staffHealthTotal.get("fevers")); // 发热人数
            paramMap.put("returns", returnStaffTotal.get("returns")); // 返岗人数
            // todo 今日上班企业数 当日返京数、上岗人员数
            EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
            String[] strs = ids.split(",");
            for (int t = 0; t <strs.length ; t++){
                enterpriseCriteria.setEnterpriseCode(strs[t]);
                List<EnterpriseReportImportantPersonStat> importantPersonStats=this.getImportantPersonsStatics2(enterpriseCriteria);
                for(EnterpriseReportImportantPersonStat person: importantPersonStats) {
                    if(person.getStatus().equals("经停过湖北")){
                        viaNum = viaNum + person.getTotal();
                    }
                }
            }
            paramMap.put("viaHubei",viaNum);

        }
        return paramMap;
    }
    /**
     * 重点区域统计
     * @param query 查询条件
     * @return
     */
    @Override
    public AreaStatisticsResultModel getImportantAreaStatistics(ImportantAreaStatSearch query) {
        // todo 调用手机端接口
        HttpEntity<ImportantAreaStatSearch> entity = new HttpEntity<>(query);
        String url="http://39.105.209.108:8090/api/enterprise/report/importantAreaStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url,HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>(){}).getBody().getData();

        return null;
    }

    /**
     * 返程方式统计
     * @param enterpriseInfo 查询条件
     * @return
     */
    @Override
    public List<WayBackStatisticsResultModel> getWayBackStatistics(String enterpriseInfo) {
        // todo 与前端进行联调
        String url = "http://39.105.209.108:8090/api/enterprise/report/queryReturnVehicleCountNum?enterpriseInfo=";
        Result results = restTemplate.postForObject(url+ enterpriseInfo, null, Result.class);
        List<WayBackStatisticsResultModel> result = (List<WayBackStatisticsResultModel>)results.getData();
        return result;
    }

    /**
     * 未来七天返岗人员统计日历
     * @param enterpriseCriteria
     * @return
     */
    @Override
    public SevenDayReturnPersonStatisticsCalendar getSevenDayReturnPersonStatisticsCalendar(EnterpriseCriteria enterpriseCriteria) {
        // todo 调用手机端接口
        String url="http://39.105.209.108:8090/api/enterprise/report/postPersonStat";
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url,HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>(){}).getBody().getData();
        return null;
    }
}
