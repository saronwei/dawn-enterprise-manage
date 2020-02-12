package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseCriteria;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportImportantPersonStat;
import com.gsafety.dawn.enterprise.manage.contract.model.ReportedPersonInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.model.Result;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
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
        String url = "http://39.105.209.108:8090/api/enterprise/report/importantPersonStat2";
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
    public String getParkId(String companyId) {
        String sql = "select area_id as parkId from be_company where company_id=:companyId";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("companyId", companyId);
        return jdbcTemplate.queryForObject(sql,paramMap,String.class);
    }
}
