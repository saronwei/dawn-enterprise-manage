package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.DailyTroubleshootRecordModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseTypeModel;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseTypeService;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseTypeEntity;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * The type enterprise type controller.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api", tags = "EnterpriseType Api")
public class EnterpriseTypeController {

    /**
     * 企业类型服务
     */
    @Autowired
    private EnterpriseTypeService enterpriseTypeService;


    @GetMapping(value = "/enterprise-type")
    @ApiOperation(value = "查询企业类型顶级节点", notes = "getFirstLevelEnterprise()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Map.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseTypeModel>> getFirstLevelEnterprise() {
        List<EnterpriseTypeModel> enterpriseTypeModels = enterpriseTypeService.getFirstLevelEnterprise();
        return new ResponseEntity<>(enterpriseTypeModels, HttpStatus.OK);
    }

    @GetMapping(value = "/enterprise-type/id")
    @ApiOperation(value = "根据id查询企业类型子级节点", notes = "getChildNodeEnterpriseById()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Map.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseTypeModel>> getChildNodeEnterpriseById(
            @RequestBody @ApiParam(value = "父节点编号", required = true) String parentId
    ) {
        List<EnterpriseTypeModel> enterpriseTypeModels =
                enterpriseTypeService.getChildNodeEnterpriseById(parentId);
        return new ResponseEntity<>(enterpriseTypeModels, HttpStatus.OK);
    }


}
