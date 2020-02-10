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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            map.put("count", e.getValue());
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

}
