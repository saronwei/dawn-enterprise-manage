package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.DailyTroubleshootRecordModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportHistoryModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseReportHistoryService;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportHistoryEntity;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Enterprise report history controller.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api", tags = "企业信息上报历史 Api")
public class EnterpriseReportHistoryController {
    /**
     * The Enterprise report history service.
     */
    @Autowired
    EnterpriseReportHistoryService enterpriseReportHistoryService;

    /**
     * Query enterprise report history by page response entity.
     *
     * @param page     the page
     * @param pageSize the page size
     * @return the response entity
     */
    @GetMapping(value = "/enterprise-report-history/{page}/{pageSize}")
    @ApiOperation(value = "分页", notes = "queryEnterpriseReportHistoryByPage()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<EnterpriseReportHistoryModel>> queryEnterpriseReportHistoryByPage(
            @PathVariable @ApiParam(value = "page", required = true)  int page ,
            @PathVariable @ApiParam(value = "pageSize", required = true) int pageSize) {
        List<EnterpriseReportHistoryModel> result = enterpriseReportHistoryService.pagQuery(page, pageSize);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Save enterprise report history response entity.
     *
     * @param model the model
     * @return the response entity
     */
    @PostMapping(value = "/enterprise-report-history", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "新增/修改企业上报历史", notes = "saveEnterpriseReportHistory(model)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DailyTroubleshootRecordModel.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<EnterpriseReportHistoryModel> saveEnterpriseReportHistory(
            @RequestBody @ApiParam(value = "企业上报历史", required = true) EnterpriseReportHistoryModel model) {
        EnterpriseReportHistoryModel result =
                enterpriseReportHistoryService.saveEnterpriseReportHistoryByHistotyModel(model);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "删除企业上报历史")
    @ApiResponses({
            @ApiResponse(code = 204, message = "删除成功", response = Boolean.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @DeleteMapping(value = "/enterprise-report-history/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity delEnterpriseUploadHistoryById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                enterpriseReportHistoryService.delEnterpriseUploadHistoryById(id));
    }
}
