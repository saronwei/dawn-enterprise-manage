package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.*;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
            @ApiResponse(code = 200, message = "OK", response = List.class),
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
            @ApiResponse(code = 200, message = "OK", response = List.class),
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
            @ApiResponse(code = 200, message = "OK", response = List.class),
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
            @ApiResponse(code = 200, message = "OK", response = List.class),
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
    public ResponseEntity<Map> getEnterpriseStac(@PathVariable @ApiParam(value = "企业Id", required = true) String companyId) {
        Map<String, Object> rs = externalAccessService.getEnterpriseStac(companyId);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/officeStac", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "办公情况统计", notes = "getOfficeStac()")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class), @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class), @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseReportImportantPersonStat>> getOfficeStac() {
        List<EnterpriseReportImportantPersonStat> rs = externalAccessService.getOfficeStac();
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/importantAreaStatistics", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "重点区域统计", notes = "getImportantAreaStatistics()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<AreaStatisticsResultModel> getImportantAreaStatistics(@RequestBody @ApiParam(value = "查询条件", required = true) ImportantAreaStatSearch query) {
        AreaStatisticsResultModel result = externalAccessService.getImportantAreaStatistics(query);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/wayBackStatistics", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "返程方式统计", notes = "getWayBackStatistics()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<WayBackStatisticsResultModel>> getWayBackStatistics(@RequestBody @ApiParam(value = "查询条件", required = true) String enterpriseInfo) {
        List<WayBackStatisticsResultModel> result = externalAccessService.getWayBackStatistics(enterpriseInfo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/enterprise/sevenDayReturnPersonStatisticsCalendar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "未来七天返岗人员统计日历", notes = "getSevenDayReturnPersonStatisticsCalendar()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Map.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<Map<String, Object>> getSevenDayReturnPersonStatisticsCalendar(@RequestBody @ApiParam(value = "查询条件", required = true) EnterpriseCriteria enterpriseCriteria) {
        SevenDayReturnPersonStatisticsCalendar result = externalAccessService.getSevenDayReturnPersonStatisticsCalendar(enterpriseCriteria);
        if (result != null) {
            return ResponseEntity.ok(result.getData());
        } else {
            return ResponseEntity.ok(Collections.emptyMap());
        }
    }

}
