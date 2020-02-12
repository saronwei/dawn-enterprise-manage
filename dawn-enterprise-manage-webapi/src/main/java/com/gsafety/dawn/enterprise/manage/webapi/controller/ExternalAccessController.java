package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseCriteria;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportImportantPersonStat;
import com.gsafety.dawn.enterprise.manage.contract.model.ReportedPersonInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api", tags = "ExternalAccess Api")
public class ExternalAccessController {

    @Autowired
    private ExternalAccessService externalAccessService;

    @GetMapping(value = "/enterprise/reportedPersonsInfo/{reportedDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "所有已填报人员信息", notes = "getReportedPersonsInfo()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class ),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<ReportedPersonInfoModel>> getReportedPersonsInfo() {
        List<ReportedPersonInfoModel> result = externalAccessService.getReportedPersonsInfo();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/importantPersonsStatics", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "重点关注人员统计", notes = "getImportantPersonsStatics()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class ),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseReportImportantPersonStat>> getImportantPersonsStatics(@RequestBody @ApiParam(value = "查询条件", required = true) EnterpriseCriteria enterpriseCriteria) {
        List<EnterpriseReportImportantPersonStat> result = externalAccessService.getImportantPersonsStatics(enterpriseCriteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/importantPersonsStatics2", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "返岗人员接触史统计", notes = "getImportantPersonsStatics2()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class ),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseReportImportantPersonStat>> getImportantPersonsStatics2(@RequestBody @ApiParam(value = "查询条件", required = true) EnterpriseCriteria enterpriseCriteria) {
        List<EnterpriseReportImportantPersonStat> result = externalAccessService.getImportantPersonsStatics2(enterpriseCriteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/isolationStatistics", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "隔离情况统计", notes = "getIsolationStatistics()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class ),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseReportImportantPersonStat>> getIsolationStatistics(@RequestBody @ApiParam(value = "查询条件", required = true) EnterpriseCriteria enterpriseCriteria) {
        List<EnterpriseReportImportantPersonStat> result = externalAccessService.getIsolationStatistics(enterpriseCriteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/enterprise/enterpriseStac/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "企业总体情况统计", notes = "getEnterpriseStac()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<Map> getEnterpriseStac(@PathVariable  @ApiParam(value = "企业Id", required = true) String companyId) {
        Map<String, Object> rs = externalAccessService.getEnterpriseStac(companyId);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @GetMapping(value = "/enterprise/officeStac/{areaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "办公情况统计", notes = "getOfficeStac()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseReportImportantPersonStat>> getOfficeStac(@PathVariable  @ApiParam(value = "园区Id", required = true) String areaId) {
        List<EnterpriseReportImportantPersonStat> rs = externalAccessService.getOfficeStac(areaId);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @GetMapping(value = "/enterprise/areaStac", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "园区情况统计", notes = "getAreaStac()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<Map> getAreaStac() {
        Map<String, Object> rs = externalAccessService.getAreaStac();
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
