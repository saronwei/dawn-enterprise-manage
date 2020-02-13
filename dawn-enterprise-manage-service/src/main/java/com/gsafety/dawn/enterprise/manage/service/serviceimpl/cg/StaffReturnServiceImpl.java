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
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${mobile.host}")
    private String mobilHost;

    @Override
    public Map<String, Object> queryStaffReturnReportsPage(TotalStatisticsQuery tq, Pageable pageable) {
        tq.setPageNo(pageable.getPageNumber());
        tq.setPageSize(pageable.getPageSize());
        HttpEntity<TotalStatisticsQuery> entity = new HttpEntity<>(tq);
        Result<Map> results = restTemplate.exchange(this.mobilHost + "/api/enterprise/report/search", HttpMethod.POST, entity, Result.class).getBody();
        Map map = results.getData();
        List<Map> ww = (List<Map>)map.get("list");
        List<StaffReturnInfoModel> listss = new ArrayList<>();
        StaffReturnInfoModel staffReturnInfoModel;
        for(Map masp : ww) {
            staffReturnInfoModel = new StaffReturnInfoModel();
            this.toStaffReturnModel(staffReturnInfoModel, masp);
            listss.add(staffReturnInfoModel);
        }
        Integer to = (Integer)map.get("total");
        Map<String, Object> rrr = new HashMap<>();
        rrr.put("total", to);
        rrr.put("list", listss);
        return rrr;
    }

    @Override
    public StaffReturnInfoModel getStaffInfo(String id) {
        Result result = restTemplate.postForObject(this.mobilHost + "/api/enterprise/report/findOne?name="+ id, null, Result.class);
        // Result result = restTemplate.postForObject("http://39.105.209.108:8090/api/enterprise/report/findOne?name={1}", new HttpEntity<>(), Result.class, map);
        Map masp = (Map)result.getData();
        if(masp == null) {
            return null;
        }
        StaffReturnInfoModel staffReturnInfoModel = new StaffReturnInfoModel();
        this.toStaffReturnModel(staffReturnInfoModel, masp);
        //StaffReturnInfoEntity staffReturnInfoEntity = staffReturnRepository.getOne(id);
        return staffReturnInfoModel;
    }

    private void toStaffReturnModel(StaffReturnInfoModel staffReturnInfoModel, Map<String, Object> masp) {
        staffReturnInfoModel.setId((String)masp.get("id"));
        staffReturnInfoModel.setName((String)masp.get("name"));
        staffReturnInfoModel.setIdentificationNumber(masp.get("idNumber") == null ? null : String.valueOf(masp.get("idNumber")));
        staffReturnInfoModel.setSex(masp.get("sex") == null ? null : String.valueOf(masp.get("sex")));
        staffReturnInfoModel.setUnit(masp.get("unit") == null ? null : String.valueOf(masp.get("unit")));
        staffReturnInfoModel.setDepartment(masp.get("deptmentName") == null ? null : String.valueOf(masp.get("deptmentName")));
        staffReturnInfoModel.setNumber(masp.get("employeeCode") == null ? null : String.valueOf(masp.get("employeeCode")));
        staffReturnInfoModel.setJob(masp.get("job") == null ? null : String.valueOf(masp.get("job")));
        staffReturnInfoModel.setAddress(masp.get("address") == null ? null : String.valueOf(masp.get("address")));
        staffReturnInfoModel.setCurrentCity(masp.get("currentCity") == null ? null : String.valueOf(masp.get("currentCity")));
        staffReturnInfoModel.setIsPassHubei(masp.get("passHubei") == null ? null : String.valueOf(masp.get("passHubei")));
        staffReturnInfoModel.setIsTouchHubei(masp.get("fourteenDayTouchHubei") == null ? null : String.valueOf(masp.get("fourteenDayTouchHubei")));
        staffReturnInfoModel.setIsTouchWuhan(masp.get("fourteenDayTouchWuhan") == null ? null : String.valueOf(masp.get("fourteenDayTouchWuhan")));
        staffReturnInfoModel.setIsContactHubeiPerson(masp.get("touchHubei") == null ? null : String.valueOf(masp.get("touchHubei")));
        staffReturnInfoModel.setFamily(masp.get("backTogether") == null ? null : String.valueOf(masp.get("backTogether")));
        staffReturnInfoModel.setGoCity(masp.get("toCity") == null ? null : String.valueOf(masp.get("toCity")));
        staffReturnInfoModel.setPlanReturnTime(masp.get("planBackDate") == null ? null : String.valueOf(masp.get("planBackDate")));
        staffReturnInfoModel.setFamilyHealth(masp.get("familySymptom") == null ? null : String.valueOf(masp.get("familySymptom")));
        staffReturnInfoModel.setReportTime(masp.get("createTime") == null ? null : String.valueOf(masp.get("createTime")));
        staffReturnInfoModel.setUnit(masp.get("enterpriseName") == null ? null : String.valueOf(masp.get("enterpriseName")));
        staffReturnInfoModel.setIsCommitteeReport(masp.get("reportCommittee") == null ? null : String.valueOf(masp.get("reportCommittee")));
        staffReturnInfoModel.setIsExceedTemp(masp.get("fever") == null ? null : String.valueOf(masp.get("fever")));
        staffReturnInfoModel.setOtherSymptomsList(masp.get("symptom") == null ? null : String.valueOf(masp.get("symptom")));
        staffReturnInfoModel.setWorkerStatue(masp.get("dutyStatus") == null ? null : String.valueOf(masp.get("dutyStatus")));
        staffReturnInfoModel.setPhone(masp.get("phone") == null ? null : String.valueOf(masp.get("phone")));
        staffReturnInfoModel.setTransport(masp.get("vehicle") == null ? null : String.valueOf(masp.get("vehicle")));
        staffReturnInfoModel.setIsReturn(masp.get("back") == null ? null : String.valueOf(masp.get("back")));
        staffReturnInfoModel.setIsIsolation(masp.get("fourteenDayIsolation") == null ? null : String.valueOf(masp.get("fourteenDayIsolation")));

        staffReturnInfoModel.setTemperature(masp.get("temperature") == null ? null : String.valueOf(masp.get("temperature")));
        staffReturnInfoModel.setBackStartingPoint(masp.get("backStartingPoint") == null ? null : String.valueOf(masp.get("backStartingPoint")));
        staffReturnInfoModel.setBackVehicle(masp.get("backVehicle") == null ? null : String.valueOf(masp.get("backVehicle")));
        staffReturnInfoModel.setBackTrainNumber(masp.get("backTrainNumber") == null ? null : String.valueOf(masp.get("backTrainNumber")));
        staffReturnInfoModel.setOtherPlaceBack(masp.get("otherPlaceBack") == null ? null : String.valueOf(masp.get("otherPlaceBack")));
        staffReturnInfoModel.setTodayOfficeSituation(masp.get("todayOfficeSituation") == null ? null : String.valueOf(masp.get("todayOfficeSituation")));
        staffReturnInfoModel.setPersonnelType(masp.get("personnelType") == null ? null : String.valueOf(masp.get("personnelType")));
        staffReturnInfoModel.setNativePlace(masp.get("nativePlace") == null ? null : String.valueOf(masp.get("nativePlace")));
        staffReturnInfoModel.setPostDate(masp.get("postDate") == null ? null : String.valueOf(masp.get("postDate")));
        staffReturnInfoModel.setRelieveDate(masp.get("relieveDate") == null ? null : String.valueOf(masp.get("relieveDate")));
    }
}
