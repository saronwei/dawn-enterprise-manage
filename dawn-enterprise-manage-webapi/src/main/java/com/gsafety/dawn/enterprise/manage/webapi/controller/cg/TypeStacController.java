package com.gsafety.dawn.enterprise.manage.webapi.controller.cg;

import com.gsafety.dawn.enterprise.manage.contract.model.ResultModel;
import com.gsafety.dawn.enterprise.manage.contract.model.TotalStatisticsQuery;
import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.cm.StaffReturnService;
import com.gsafety.dawn.enterprise.manage.service.serviceimpl.TypeStacService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.*;

/**
 * description:
 *
 * @outhor xingek
 * @create 2020-02-10 13:05
 */
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api", tags = "TypeStatistic Api")
public class TypeStacController {


    @Autowired
    private TypeStacService typeStacService;

    @GetMapping(value = "/typestac", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "统计类型总数", notes = "typestac()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<Map>> typestac() {
        Map<String, Object> rs = typeStacService.typestac();
        List<Map> maps = new ArrayList<>();
        Map map;
        for(Map.Entry<String, Object> e : rs.entrySet()) {
            map = new HashMap();
            map.put("name", e.getKey());
            map.put("value", e.getValue());
            maps.add(map);
        }
        for(Map map1 : maps) {
            if("疑似人数".equals(map1.get("name"))) {
                map1.put("id", "001");
            }
            if("确诊人数".equals(map1.get("name"))) {
                map1.put("id", "002");
            }
            if("隔离人数".equals(map1.get("name"))) {
                map1.put("id", "003");
            }
            if("密接人数".equals(map1.get("name"))) {
                map1.put("id", "004");
            }
        }
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @GetMapping(value = "/typestac-return-person", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "统计企业返岗数", notes = "typestacPerson()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<Map> typestacPerson() {
        Map<String, Object> rs = typeStacService.typestacPerson();
        int total = Integer.parseInt(String.valueOf(rs.get("totals")));
        int returns = Integer.parseInt(String.valueOf(rs.get("returns")));
        String prencent = "0.00%";
        if(total > 0) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            prencent = numberFormat.format((float) returns / (float) total * 100) + "%";
        }
        rs.put("precents", prencent);
        return new ResponseEntity<Map>(rs, HttpStatus.OK);
    }


    @GetMapping(value = "/typestac-gov-prevention-measures", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "政府端-防疫措施统计", notes = "typestacGovPreventionMeasures()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List> typestacGovPreventionMeasures() {
        Map<String, Object> rs = new HashMap<>();//----
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map = new LinkedHashMap<>();
        for(Map.Entry<String,Object> entry : rs.entrySet()){
            map.put("name", entry.getKey());
            map.put("value", Integer.parseInt(String.valueOf(entry.getValue())));
            maps.add(map);
        }

        rs.put("name","消杀区域");
        rs.put("value", 30);
        maps.add(rs);
        return new ResponseEntity<List>(maps, HttpStatus.OK);
    }

    @GetMapping(value = "/typestac-enterprise--staff-total/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "企业端-员工总体情况统计", notes = "typestacEnterpriseStaffTotal(companyId)")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<Map> typestacEnterpriseStaffTotal(@PathVariable @ApiParam(value = "企业id", required = true) String companyId) {
        Map<String, Object> rs = typeStacService.typestacEnterpriseStaffTotal(companyId);
        int totals = Integer.parseInt(String.valueOf(rs.get("totals")));
        int returns = Integer.parseInt(String.valueOf(rs.get("returns")));
        String prencent = "0.00%";
        if(totals > 0) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            prencent = numberFormat.format((float) returns / (float) totals * 100) + "%";
        }
        rs.put("precents", prencent);
        /*rs.put("totals",1000);
        rs.put("returns", 302);
        rs.put("precents", "30.12%");
        rs.put("localReturns", 100);
        rs.put("outReturns", 120);*/
        return new ResponseEntity<Map>(rs, HttpStatus.OK);
    }

}
