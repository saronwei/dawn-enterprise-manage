package com.gsafety.dawn.enterprise.manage.service.serviceimpl.cg;

import com.gsafety.dawn.enterprise.manage.contract.model.Data;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReport;
import com.gsafety.dawn.enterprise.manage.contract.model.Result;
import com.gsafety.dawn.enterprise.manage.contract.model.TotalStatisticsQuery;
import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.cm.StaffReturnService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.cg.StaffReturnMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.cg.StaffReturnInfoEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.cg.StaffReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class StaffReturnServiceImpl implements StaffReturnService {


    @Autowired
    StaffReturnRepository staffReturnRepository;

    @Autowired
    StaffReturnMapper staffReturnMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Map<String, Object> queryStaffReturnReportsPage(TotalStatisticsQuery tq, Pageable pageable) {
        /*{
            "deptmentCode": "string",
                "deptmentName": "string",
                "endDate": "2020-02-08 11:15:15",
                "enterpriseCode": "string",
                "enterpriseName": "string",
                "pageNo": 0,
                "pageSize": 0,
                "startDate": "2020-02-08 10:10:41"
        }*/
        tq.setPageNo(pageable.getPageNumber());
        tq.setPageSize(pageable.getPageSize());
        HttpEntity<TotalStatisticsQuery> entity = new HttpEntity<>(tq);
        Result<Map> results = restTemplate.exchange("http://39.105.209.108:8090/api/enterprise/report/search", HttpMethod.POST, entity, Result.class).getBody();
        Map map = results.getData();
        List<Map> ww = (List<Map>)map.get("list");
        List<StaffReturnInfoModel> listss = new ArrayList<>();
        StaffReturnInfoModel staffReturnInfoModel;
        for(Map masp : ww) {
            staffReturnInfoModel = new StaffReturnInfoModel();
            staffReturnInfoModel.setName((String)masp.get("name"));
            staffReturnInfoModel.setAddress((String)masp.get("address"));
            staffReturnInfoModel.setDepartment((String)masp.get("deptmentName"));
            staffReturnInfoModel.setId((String)masp.get("id"));
            staffReturnInfoModel.setCurrentCity((String)masp.get("currentCity"));
            staffReturnInfoModel.setIsTouchHubei((String)masp.get("passHubei"));
            staffReturnInfoModel.setIsContactHubeiPerson(masp.get("touchHubei") == null ? null : (String)masp.get("touchHubei"));
            staffReturnInfoModel.setFamily((String)masp.get("backTogether"));
            staffReturnInfoModel.setGoCity((String)masp.get("toCity"));
            staffReturnInfoModel.setPlanReturnTime((String)masp.get("planBackDate"));
            staffReturnInfoModel.setFamilyHealth(masp.get("familySymptom") == null ? null : String.valueOf(masp.get("familySymptom")));
            staffReturnInfoModel.setIsPassHubei(masp.get("passHubei") == null ? null : String.valueOf(masp.get("passHubei")));
            staffReturnInfoModel.setReportTime((String)masp.get("createTime"));
            staffReturnInfoModel.setUnit((String)masp.get("enterpriseName"));
            staffReturnInfoModel.setIsTouchWuhan(masp.get("fourteenDayTouchWuhan") == null ? null : String.valueOf(masp.get("fourteenDayTouchWuhan")));
            staffReturnInfoModel.setIsCommitteeReport(masp.get("reportCommittee") == null ? null : String.valueOf(masp.get("reportCommittee")));
            staffReturnInfoModel.setNumber(String.valueOf(masp.get("employeeCode")));
            staffReturnInfoModel.setIsExceedTemp(masp.get("fever") == null ? null : String.valueOf(masp.get("fever")));
            staffReturnInfoModel.setOther(String.valueOf(masp.get("symptom")));
            staffReturnInfoModel.setWorkerStatue(String.valueOf(masp.get("dutyStatus")));
            staffReturnInfoModel.setPhone(String.valueOf(masp.get("phone")));
            staffReturnInfoModel.setIsContactHubeiPerson(masp.get("fourteenDayTouchHubei") == null ? null : String.valueOf(masp.get("fourteenDayTouchHubei")));
            staffReturnInfoModel.setTransport(masp.get("vehicle") == null ? null : String.valueOf(masp.get("vehicle")));
            staffReturnInfoModel.setJob(masp.get("job") == null ? null : String.valueOf(masp.get("job")));
            staffReturnInfoModel.setIsReturn(masp.get("back") == null ? null : String.valueOf(masp.get("back")));
            staffReturnInfoModel.setIsIsolation(masp.get("fourteenDayIsolation") == null ? null : String.valueOf(masp.get("fourteenDayIsolation")));
            listss.add(staffReturnInfoModel);

        }
        Integer to = (Integer)map.get("total");

        //List<StaffReturnInfoModel> staffReturnInfoModels = staffReturnMapper.fromEnterpriseReports(results.getData().getList());
        //Page<StaffReturnInfoEntity> pages = staffReturnRepository.findAll(pageable);
        Page page = new PageImpl(listss, pageable, to);
        Map<String, Object> rrr = new HashMap<>();
        rrr.put("total", to);
        rrr.put("list", listss);
        return rrr;
    }

    @Override
    public StaffReturnInfoModel getStaffInfo(String id) {
        Result result = restTemplate.postForObject("http://39.105.209.108:8090/api/enterprise/report/findOne?name="+ id, null, Result.class);
        // Result result = restTemplate.postForObject("http://39.105.209.108:8090/api/enterprise/report/findOne?name={1}", new HttpEntity<>(), Result.class, map);
        Map masp = (Map)result.getData();
        if(masp == null) {
            return null;
        }
        StaffReturnInfoModel staffReturnInfoModel;
        staffReturnInfoModel = new StaffReturnInfoModel();
        staffReturnInfoModel.setName((String)masp.get("name"));
        staffReturnInfoModel.setAddress((String)masp.get("address"));
        staffReturnInfoModel.setDepartment((String)masp.get("deptmentName"));
        staffReturnInfoModel.setId((String)masp.get("id"));
        staffReturnInfoModel.setCurrentCity((String)masp.get("currentCity"));
        staffReturnInfoModel.setIsTouchHubei((String)masp.get("passHubei"));
        staffReturnInfoModel.setIsContactHubeiPerson(masp.get("touchHubei") == null ? null : (String)masp.get("touchHubei"));
        staffReturnInfoModel.setFamily((String)masp.get("backTogether"));
        staffReturnInfoModel.setGoCity((String)masp.get("toCity"));
        staffReturnInfoModel.setPlanReturnTime((String)masp.get("planBackDate"));
        staffReturnInfoModel.setFamilyHealth(masp.get("familySymptom") == null ? null : String.valueOf(masp.get("familySymptom")));
        staffReturnInfoModel.setIsPassHubei(masp.get("passHubei") == null ? null : String.valueOf(masp.get("passHubei")));
        staffReturnInfoModel.setReportTime((String)masp.get("createTime"));
        staffReturnInfoModel.setUnit((String)masp.get("enterpriseName"));
        staffReturnInfoModel.setIsTouchWuhan(masp.get("fourteenDayTouchWuhan") == null ? null : String.valueOf(masp.get("fourteenDayTouchWuhan")));
        staffReturnInfoModel.setIsCommitteeReport(masp.get("reportCommittee") == null ? null : String.valueOf(masp.get("reportCommittee")));
        staffReturnInfoModel.setNumber(String.valueOf(masp.get("employeeCode")));
        staffReturnInfoModel.setIsExceedTemp(masp.get("fever") == null ? null : String.valueOf(masp.get("fever")));
        staffReturnInfoModel.setOther(String.valueOf(masp.get("symptom")));
        staffReturnInfoModel.setWorkerStatue(String.valueOf(masp.get("dutyStatus")));
        staffReturnInfoModel.setPhone(String.valueOf(masp.get("phone")));
        staffReturnInfoModel.setIsContactHubeiPerson(masp.get("fourteenDayTouchHubei") == null ? null : String.valueOf(masp.get("fourteenDayTouchHubei")));
        staffReturnInfoModel.setTransport(masp.get("vehicle") == null ? null : String.valueOf(masp.get("vehicle")));
        staffReturnInfoModel.setJob(masp.get("job") == null ? null : String.valueOf(masp.get("job")));
        staffReturnInfoModel.setIsReturn(masp.get("back") == null ? null : String.valueOf(masp.get("back")));
        staffReturnInfoModel.setIsIsolation(masp.get("fourteenDayIsolation") == null ? null : String.valueOf(masp.get("fourteenDayIsolation")));
        //StaffReturnInfoEntity staffReturnInfoEntity = staffReturnRepository.getOne(id);
        return staffReturnInfoModel;
    }
}
