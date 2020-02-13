package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.manage.contract.model.*;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseInfoRepository;
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
    @Autowired
    private EnterpriseInfoRepository enterpriseInfoRepository;

    @Value("${mobile.host}")
    private String mobilHost;

    @Override
    public List<ReportedPersonInfoModel> getReportedPersonsInfo() {
        // todo 调用手机端接口
        return null;
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getImportantPersonsStatics(EnterpriseCriteria enterpriseCriteria) {
        // todo 调用手机端接口
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = this.mobilHost + "/api/enterprise/report/importantPersonStat";
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
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = this.mobilHost + "/api/enterprise/report/importantPersonStat2";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
        return result;
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getIsolationStatistics(EnterpriseCriteria enterpriseCriteria) {
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = this.mobilHost + "/api/enterprise/report/isolationPersonStat";
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

    // 办公情况统计用（根据园区id传）
    @Override
    public List<EnterpriseReportImportantPersonStat> getOfficeStac(String areaId) {
//        if (areaId.equals("")) {
        if (StringUtils.isEmpty(areaId)) {
            areaId = "area-0005";
        }
//        String ids = this.typeStacService.comps(areaId);
//        String names = this.getCompanyNames(areaId);
        String ids = this.getCompanyIds(areaId);
        EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
        enterpriseCriteria.setEnterpriseCode(ids);
//        enterpriseCriteria.setEnterpriseName(names);
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = this.mobilHost + "/api/enterprise/report/workTypeStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
        return result;
    }
    // 办公情况统计用2(根据公司id查)
    public List<EnterpriseReportImportantPersonStat> getOfficeStac2(String companyId) {
        EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
        enterpriseCriteria.setEnterpriseCode(companyId);
//        enterpriseCriteria.setEnterpriseName(companyId);
        HttpEntity<EnterpriseCriteria> entity = new HttpEntity<>(enterpriseCriteria);
        String url = this.mobilHost + "/api/enterprise/report/workTypeStat";
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
        return StringUtils.arrayToCommaDelimitedString(ss.toArray(new String[0]));
    }

    // 根据园区id查询公司id
    public String getCompanyIds(String areaId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("areaId", areaId);
        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select a.company_id as companyId from be_company a where a.area_id = :areaId", paramMap);
        List<String> ss = new ArrayList<>();
        for (Map<String, Object> mm : ll) {
            ss.add((String) mm.get("companyId"));
        }
        return StringUtils.arrayToCommaDelimitedString(ss.toArray(new String[0]));
    }

    // 查询园区id
    public List<String> getAreaIds() {
        String sql = "select area_id as areaId from be_area";
        return jdbcTemplate.queryForList(sql, new HashMap<>(), String.class);
    }
    // 查询园区name,id
    public List<Map<String,Object>> getAreaNamesAndIds() {
        String sql = "select area_id as areaId,name as areaName from be_area";
        return jdbcTemplate.queryForList(sql, new HashMap<>());
    }

    // 获取所有园区的所有企业id(name)
    public List<Map<String,Object>> getEnterpriseIds() {
/*        List<String> areaList = this.getAreaIds();
        List<String> companyIdList = new ArrayList<>();
        for (String areaId : areaList) {
//            String sql = "select company_id as companyId from be_company where area_id=:areaId";
            String sql = "select name as companyId from be_company where area_id=:areaId";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("areaId", areaId);
            List<String> list = jdbcTemplate.queryForList(sql, paramMap, String.class);
            String companyIds = "";
            for (String str : list) {
                companyIds += str + ",";
            }
            companyIdList.add(companyIds);
        }*/
        List<Map<String,Object>> areaList = this.getAreaNamesAndIds();
        List<Map<String,Object>> companyIdList = new ArrayList<>();
        Map<String,Object> newMap = new HashMap<>();
        for (Map<String,Object> map : areaList) {
            newMap = new HashMap<>();
            String areaId = (String) map.get("areaId");
            String sql = "select company_id as companyId from be_company where area_id=:areaId";
//            String sql = "select name as companyId from be_company where area_id=:areaId";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("areaId", areaId);
            List<String> list = jdbcTemplate.queryForList(sql, paramMap, String.class);
            String companyIds = "";
            for (String str : list) {
                companyIds += str + ",";
            }
            newMap.put("companyIds",companyIds);
            newMap.put("areaName",map.get("areaName"));
            newMap.put("areaId",map.get("areaId"));
            companyIdList.add(newMap);
        }
        return companyIdList;
    }

    // 获取园区情况统计
    @Override
    public List<Map<String, Object>> getAreaStac() {
        List<Map<String, Object>> areaStacList = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();
//        List<String> companyList = this.getEnterpriseIds();
        List<Map<String,Object>> companyList = this.getEnterpriseIds();
        Integer viaNum = 0;
        Integer isolationNum = 0;
        Integer todayRemoteWorkNum = 0;
        Integer todaySceneWorkNum = 0;
        Integer todayReturnNum = 0;
//        for(String ids: companyList) {
        for(Map<String,Object> ids: companyList) {
            paramMap = new HashMap<>();
            Map<String,Object> staffHealthTotal= typeStacService.typestacEnterpriseStaffHealthTotal((String) ids.get("companyIds"));// 原来为ids
            Map<String, Object> returnStaffTotal = typeStacService.typestacEnterpriseStaffTotal((String) ids.get("companyIds")); //
            paramMap.put("areaName",(String) ids.get("areaName")); // 园区名称
            paramMap.put("areaId",(String) ids.get("areaId")); // 园区id
            paramMap.put("colds", staffHealthTotal.get("colds"));// 感冒人数
            paramMap.put("fevers", staffHealthTotal.get("fevers")); // 发热人数
            paramMap.put("returns", returnStaffTotal.get("returns")); // 返岗人数
//            // todo 今日上班企业数(等待接口))
//            paramMap.put("workCompanys", 0); // 今日上班企业数
            EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
            String[] strs = ((String) ids.get("companyIds")).split(",");//
            for (int t = 0; t < strs.length; t++) {
                enterpriseCriteria.setEnterpriseCode(strs[t]);
//                enterpriseCriteria.setEnterpriseName(strs[t]);
                List<EnterpriseReportImportantPersonStat> importantPersonStats = this.getImportantPersonsStatics2(enterpriseCriteria);
                for (EnterpriseReportImportantPersonStat person : importantPersonStats) {
                    if (person.getStatus().equals("经停过湖北")) {
                        viaNum = viaNum + person.getTotal();
                    }
                }
                // 解除隔离人数
                List<EnterpriseReportImportantPersonStat> isolationList = this.getIsolationStatistics(enterpriseCriteria);
                for (EnterpriseReportImportantPersonStat isolationPerson : isolationList) {
                    if (isolationPerson.getStatus().equals("今日解除隔离人数")) {
                        isolationNum = isolationNum + isolationPerson.getTotal();
                    }
                }
                // 当日返岗人数
                SevenDayReturnPersonStatisticsCalendar currentReturnPersons = this.getSevenDayReturnPersonStatisticsCalendar(enterpriseCriteria);
                Date date = new Date();//获取当前的日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");//设置日期格式
                String str = df.format(date);
                for (Map<String, Object> m : (List<Map>) currentReturnPersons.getData().get("list")) {
                    if (m.get("date").equals(str)) {
                        todayReturnNum = todayReturnNum + (Integer) m.get("num");
                    }
                }
                // 上岗人数
                List<EnterpriseReportImportantPersonStat> officeList = this.getOfficeStac2(strs[t]);
                for (EnterpriseReportImportantPersonStat office: officeList) {
                    if(office.getX().equals("1") && office.getS().equals("2")) {
                        todaySceneWorkNum = todaySceneWorkNum + office.getY();
                    }
                    if(office.getX().equals("1") && office.getS().equals("1")) {
                        todayRemoteWorkNum = todayRemoteWorkNum + office.getY();
                    }
                }
            }
            paramMap.put("viaHubei",viaNum); // 经停过湖北
            paramMap.put("isolationNum",isolationNum); // 解除隔离人数
            paramMap.put("todayReturnNum",todayReturnNum); // 当日返岗人数
            paramMap.put("todayOnDutyNum",todaySceneWorkNum); // 上岗人数=现场办公人数
            paramMap.put("workCompanys", todaySceneWorkNum + todayRemoteWorkNum); // 今日上班人数=现场办公人数+远程办公人数
            areaStacList.add(paramMap);
        }
        return areaStacList;
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
        String url = this.mobilHost + "/api/enterprise/report/importantAreaStat";
        List<EnterpriseReportImportantPersonStat> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Result<List<EnterpriseReportImportantPersonStat>>>() {
                }).getBody().getData();
        AreaStatisticsResultModel areaStatisticsResultModel = new AreaStatisticsResultModel();
        areaStatisticsResultModel.setTotal1(0);
        areaStatisticsResultModel.setTotal2(0);
        if (result != null && !CollectionUtils.isEmpty(result)) {
            EnterpriseReportImportantPersonStat e1 =
                    result.stream().filter(o -> o.getStatus().equals("区域已返工人数")).findFirst().orElse(null);
            ;
            EnterpriseReportImportantPersonStat e2 =
                    result.stream().filter(o -> o.getStatus().equals("解除隔离返岗员工人数")).findFirst().orElse(null);
            ;
            areaStatisticsResultModel.setTotal1(e1 == null ? 0 : e1.getTotal());
            areaStatisticsResultModel.setTotal2(e2 == null ? 0 : e2.getTotal());
        }
        return areaStatisticsResultModel;
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
        String url = this.mobilHost + "/api/enterprise/report/queryReturnVehicleCountNum?enterpriseInfo=";
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
        String url = this.mobilHost + "/api/enterprise/report/postPersonStat";
        return restTemplate.postForObject(url, enterpriseCriteria, SevenDayReturnPersonStatisticsCalendar.class);
    }

    @Override
    public List<EnterpriseReportImportantPersonStat> getOfficeStac() {
        return null;
    }


    @Override
    public CompanyPageSearchResult getCompanyStatisticsWithPage(CompanyQueryInfo queryInfo) {
        CompanyPageSearchResult result = new CompanyPageSearchResult();
        List<CompanyReturnBaseInfo> infoList = new ArrayList<>();
        Integer viaNum = 0;
        Integer isolationNum = 0;

        // 分页查询企业信息
        List<Object[]> objects = enterpriseInfoRepository.searchWithPage(
                queryInfo.getAreaId(), queryInfo.getCompanyName(),
                queryInfo.getPageSize(), queryInfo.getPageIndex());

        /// 遍历企业信息
        if (!objects.isEmpty()) {
            for (Object[] object : objects) {
                if (object != null) {
                    // 新建企业信息对象
                    CompanyReturnBaseInfo info = new CompanyReturnBaseInfo();
                    // 赋值企业名称
                    info.setCompanyName(object[1].toString());
                    // 根据园区id获取上岗人数
                    List<EnterpriseReportImportantPersonStat> officeList = getOfficeStac(queryInfo.getAreaId());

                    // 赋值上岗人数
                    info.setWorkingTotal(officeList.size());

                    // 根据companyId获取返京人数
                    Map<String, Object> returnStaffTotal = typeStacService.typestacEnterpriseStaffTotal(object[0].toString());
                    info.setReturnBeiJingTotal(Integer.parseInt(returnStaffTotal.get("returns").toString()));

                    EnterpriseCriteria enterpriseCriteria = new EnterpriseCriteria();
                    enterpriseCriteria.setEnterpriseCode(object[0].toString());
                    // 途经湖北
                    List<EnterpriseReportImportantPersonStat> importantPersonStats = getImportantPersonsStatics2(enterpriseCriteria);
                    for (EnterpriseReportImportantPersonStat person : importantPersonStats) {
                        if (person.getStatus().equals("经停过湖北")) {
                            viaNum = viaNum + person.getTotal();
                        }
                    }

                    // 赋值途经湖北人数
                    info.setAccrossHuBeiTotal(viaNum);

                    // 解除隔离
                    List<EnterpriseReportImportantPersonStat> isolationList = this.getIsolationStatistics(enterpriseCriteria);
                    for (EnterpriseReportImportantPersonStat isolationPerson : isolationList) {
                        if (isolationPerson.getStatus().equals("今日解除隔离")) {
                            isolationNum = isolationNum + isolationPerson.getTotal();
                        }
                    }
                    // 赋值解除隔离人数
                    info.setDisisolationTotal(isolationNum);
                    infoList.add(info);
                }
            }
            // 赋值企业总条数
            result.setTotal(Integer.parseInt(objects.get(0)[3].toString()));
            result.setInfoList(infoList);
        }
        return result;
    }
}
