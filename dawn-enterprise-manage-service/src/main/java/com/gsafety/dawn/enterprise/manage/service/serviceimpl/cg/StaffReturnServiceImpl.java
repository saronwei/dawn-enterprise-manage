package com.gsafety.dawn.enterprise.manage.service.serviceimpl.cg;

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
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StaffReturnServiceImpl implements StaffReturnService {


    @Autowired
    StaffReturnRepository staffReturnRepository;

    @Autowired
    StaffReturnMapper staffReturnMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Page<StaffReturnInfoModel> queryStaffReturnReportsPage(Pageable pageable) {
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
        TotalStatisticsQuery tq = new TotalStatisticsQuery();
        tq.setEnterpriseCode("");
        tq.setPageNo(pageable.getPageNumber());
        tq.setPageSize(pageable.getPageSize());
        HttpEntity<TotalStatisticsQuery> entity = new HttpEntity<>(tq);
        Result<List<EnterpriseReport>> results = restTemplate.exchange("http://39.105.209.108:8090/api/enterprise/total/statistics", HttpMethod.POST, entity, Result.class).getBody();
        //Page<StaffReturnInfoEntity> pages = staffReturnRepository.findAll(pageable);
        //Page page = new PageImpl(staffReturnMapper.entitiesToModels(pages.getContent()), pageable, pages.getTotalElements());
        return null;
    }

    @Override
    public StaffReturnInfoModel getStaffInfo(String id) {
        StaffReturnInfoEntity staffReturnInfoEntity = staffReturnRepository.getOne(id);
        return staffReturnMapper.toModel(staffReturnInfoEntity);
    }
}
