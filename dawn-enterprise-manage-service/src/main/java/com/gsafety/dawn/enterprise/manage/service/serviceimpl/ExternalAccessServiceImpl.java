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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExternalAccessServiceImpl implements ExternalAccessService {
    @Autowired
    private RestTemplate restTemplate;
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
//        List<EnterpriseReportImportantPersonStat> results = new ArrayList<>();
//        for(EnterpriseReportImportantPersonStat personStaticsModel : result) {
//            personStaticsModel.setName(personStaticsModel.getStatus());
//            personStaticsModel.setCount(personStaticsModel.getTotal());
//            personStaticsModel.setValue(personStaticsModel.getTotal());
//            personStaticsModel.setSelected(false);
//        }
        return result;
    }
}
