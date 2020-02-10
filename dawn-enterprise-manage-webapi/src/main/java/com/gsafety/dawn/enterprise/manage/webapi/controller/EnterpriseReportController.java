package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportQueryInfo;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseReportService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.java.common.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/api/v1", tags = "EnterpriseReport Api")
@RestController
@RequestMapping("/api/v1")
public class EnterpriseReportController {
    @Autowired
    private EnterpriseReportService enterpriseReportService;

    @ApiOperation(value = "保存企业上报信息", notes = "saveEnterpriseReport")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "OK", response = EnterpriseReportModel.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "Param invalid", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @PostMapping("/enterprises/report")
    public ResponseEntity<EnterpriseReportModel> saveEnterpriseReport(@RequestBody EnterpriseReportModel enterpriseReportModel) {
        EnterpriseReportModel result = enterpriseReportService.saveEnterpriseReport(enterpriseReportModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ApiOperation(value = "多条件查询企业上报信息", notes = "findByQueryInfo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PageBean.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "Param invalid", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @PostMapping("/enterprises/report/search")
    public ResponseEntity<PageBean<EnterpriseReportModel>> findByQueryInfo(@RequestBody EnterpriseReportQueryInfo queryInfo) {
        PageBean<EnterpriseReportModel> result = enterpriseReportService.findByQueryInfo(queryInfo);
        return ResponseEntity.ok(result);
    }

}
