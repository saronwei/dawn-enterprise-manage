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
import java.text.SimpleDateFormat;
import java.util.*;

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
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
//        List<EnterpriseReportImportantPersonStat> results = new ArrayList<>();
        for (EnterpriseReportImportantPersonStat personStaticsModel : result) {
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
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
        return result;
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getIsolationStatistics(EnterpriseCriteria enterpriseCriteria) {
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = "http://39.105.209.108:8090/api/enterprise/report/isolationPersonStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
        return result;
    }

    @Override
    public Map getEnterpriseStac(String companyId) {
        String areaId = this.getParkId(companyId);
        String sql = "select COUNT(*) as enterpriseTotals, SUM(COALESCE(CAST(staff_num AS INTEGER ), 0)) as enterprisePersonTotals from be_company where area_id=:areaId";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("areaId", areaId);
        return jdbcTemplate.queryForMap(sql, paramMap);
    }

    // 办公情况统计用
    @Override
    public List<EnterpriseReportImportantPersonStat> getOfficeStac(String areaId) {
        if (areaId.equals("")) {
            areaId = "area-0005";
        }
        String ids = this.typeStacService.comps(areaId); // todo 传企业id
        String names = this.getCompanyNames(areaId);
        EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
        enterpriseCriteria.setEnterpriseCode(ids);
        enterpriseCriteria.setEnterpriseName(names);
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = "http://39.105.209.108:8090/api/enterprise/report/workTypeStat"; // todo 手机端
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
        return result;
    }

    public String getParkId(String companyId) {
        String sql = "select area_id as parkId from be_company where company_id=:companyId";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("companyId", companyId);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public String getCompanyNames(String companyId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select a.name as companyName from be_company a where a.area_id = (select area_id from be_company where company_id = :companyId)", paramMap);
        List<String> ss = new ArrayList<>();
        for (Map<String, Object> mm : ll) {
            ss.add((String) mm.get("companyName"));
        }
        return StringUtils.arrayToCommaDelimitedString(ll.toArray(new String[0]));
    }

    // 查询园区表
    public List<String> getAreaIds() {
        String sql = "select area_id as areaId from be_area";
        return jdbcTemplate.queryForList(sql, new HashMap<>(), String.class);
    }

    // 获取所有园区的所有企业id
    public List<String> getEnterpriseIds() {
        List<String> areaList = this.getAreaIds();
        List<String> companyIdList = new ArrayList<>();
        for (String areaId : areaList) {
            String sql = "select company_id as companyId from be_company where area_id=:areaId";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("areaId", areaId);
            List<String> list = jdbcTemplate.queryForList(sql, paramMap, String.class);
            String companyIds = "";
            for (String str : list) {
                companyIds += str + ",";
            }
            companyIdList.add(companyIds);
        }

        return companyIdList;
    }

    // 获取园区情况统计
    @Override
    public Map<String,Object> getAreaStac() {
        Map<String, Object> paramMap = new HashMap<>();
        List<String> companyList = this.getEnterpriseIds();
        Integer viaNum = 0;
        Integer isolationNum = 0;
        Integer todayRemoteWorkNum = 0;
        Integer todaySceneWorkNum = 0;
        Integer todayReturnNum = 0;
        for(String ids: companyList) {
            Map<String,Object> staffHealthTotal= typeStacService.typestacEnterpriseStaffHealthTotal(ids);
            Map<String, Object> returnStaffTotal = typeStacService.typestacEnterpriseStaffTotal(ids);
            paramMap.put("colds", staffHealthTotal.get("colds"));// 感冒人数
            paramMap.put("fevers", staffHealthTotal.get("fevers")); // 发热人数
            paramMap.put("returns", returnStaffTotal.get("returns")); // 返岗人数
            // todo 今日上班企业数 当日返京数
            EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
            String[] strs = ids.split(",");
            for (int t = 0; t < strs.length; t++) {
                enterpriseCriteria.setEnterpriseCode(strs[t]);
                List<EnterpriseReportImportantPersonStat> importantPersonStats = this.getImportantPersonsStatics2(enterpriseCriteria);
                for (EnterpriseReportImportantPersonStat person : importantPersonStats) {
                    if (person.getStatus().equals("经停过湖北")) {
                        viaNum = viaNum + person.getTotal();
                    }
                }
                // 解除隔离人数
                List<EnterpriseReportImportantPersonStat> isolationList = this.getIsolationStatistics(enterpriseCriteria);
                for(EnterpriseReportImportantPersonStat isolationPerson: isolationList) {
                    if(isolationPerson.getStatus().equals("今日解除隔离")){
                        isolationNum = isolationNum + isolationPerson.getTotal();
                    }
                }
                // 当日返岗人数
                SevenDayReturnPersonStatisticsCalendar currentReturnPersons = this.getSevenDayReturnPersonStatisticsCalendar(enterpriseCriteria);
                Date date = new Date();//获取当前的日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");//设置日期格式
                String str = df.format(date);
                for(Map<String,Object> m: (List<Map>)currentReturnPersons.getData().get("list")) {
                    if(m.get("date").equals(str)) {
                        todayReturnNum = todayReturnNum + (Integer)m.get("num");
                    }
                }
            }
            paramMap.put("viaHubei",viaNum); // 经停过湖北
            paramMap.put("isolationNum",isolationNum); // 解除隔离人数
            paramMap.put("todayReturnNum",todayReturnNum); // 当日返岗人数
        }
        List<String> areaIdList = this.getAreaIds();
        for(String areaId: areaIdList) {
            List<EnterpriseReportImportantPersonStat> officeList = this.getOfficeStac(areaId);
            for (EnterpriseReportImportantPersonStat office: officeList) {
              if(office.getX().equals("1") && office.getS().equals("2")) {
                  todaySceneWorkNum = todaySceneWorkNum + office.getY();
              }
//              if(office.getX().equals("1") && office.getS().equals("1")) {
//                  todayRemoteWorkNum = todayRemoteWorkNum + office.getY();
//              }
            }
            paramMap.put("viaHubei", viaNum);
        }
//        paramMap.put("todayWorkNum",todaySceneWorkNum + todayRemoteWorkNum); // 上班企业总人数
        paramMap.put("todayOnDutyNum",todaySceneWorkNum); // 上岗人数
        return paramMap;
    }

    /**
     * 重点区域统计
     *
     * @param query 查询条件
     * @return
     */
    @Override
    public AreaStatisticsResultModel getImportantAreaStatistics(ImportantAreaStatSearch query) {
        // todo 调用手机端接口
        HttpEntity<ImportantAreaStatSearch> entity = new HttpEntity<>(query);
        String url = "http://39.105.209.108:8090/api/enterprise/report/importantAreaStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();

        return null;
    }

    /**
     * 返程方式统计
     *
     * @param enterpriseInfo 查询条件
     * @return
     */
    @Override
    public List<WayBackStatisticsResultModel> getWayBackStatistics(String enterpriseInfo) {
        // todo 与前端进行联调
        String url = "http://39.105.209.108:8090/api/enterprise/report/queryReturnVehicleCountNum?enterpriseInfo=";
        Result results = restTemplate.postForObject(url + enterpriseInfo, null, Result.class);
        List<WayBackStatisticsResultModel> result = (List<WayBackStatisticsResultModel>) results.getData();
        return result;
    }

    /**
     * 未来七天返岗人员统计日历
     *
     * @param enterpriseCriteria
     * @return
     */
    @Override
    public SevenDayReturnPersonStatisticsCalendar getSevenDayReturnPersonStatisticsCalendar(EnterpriseCriteria enterpriseCriteria) {
        String url = "http://39.105.209.108:8090/api/enterprise/report/postPersonStat";
        return restTemplate.postForObject(url, enterpriseCriteria, SevenDayReturnPersonStatisticsCalendar.class);
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getOfficeStac() {
        return null;
    }
}
