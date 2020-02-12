package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportModel;
import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportQueryInfo;
import com.gsafety.dawn.enterprise.manage.contract.service.CompanyReportService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.java.common.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "/api/v1", tags = "企业上报信息 Api")
@RestController
@RequestMapping("/api/v1")
public class CompanyReportController {
    @Autowired
    private CompanyReportService companyReportService;

    @ApiOperation(value = "根据企业ID查询上报信息", notes = "findByCompanyId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CompanyReportModel.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "Param invalid", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @GetMapping("/company/{companyId}/report")
    public ResponseEntity<CompanyReportModel> findByCompanyId(@PathVariable String companyId) {
        CompanyReportModel result = companyReportService.findByCompanyId(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "新增企业上报信息", notes = "saveCompanyReport")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = CompanyReportModel.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "Param invalid", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @PostMapping("/company/report")
    public ResponseEntity<CompanyReportModel> saveCompanyReport(@RequestBody CompanyReportModel companyReportModel) {
        CompanyReportModel result = companyReportService.saveCompanyReport(companyReportModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ApiOperation(value = "根据企业ID更新上报信息", notes = "updateCompanyReport")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CompanyReportModel.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "Param invalid", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @PutMapping("/company/report/{reportId}")
    public ResponseEntity<CompanyReportModel> updateCompanyReport(@PathVariable("reportId") String reportId,
                                                                  @RequestBody CompanyReportModel companyReportModel) {
        companyReportModel.setReportId(reportId);
        CompanyReportModel result = companyReportService.updateCompanyReport(companyReportModel);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "多条件查询企业上报信息", notes = "findByQueryInfo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PageBean.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "Param invalid", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @PostMapping("/company/report/search")
    public ResponseEntity<PageBean<CompanyReportModel>> findByQueryInfo(@RequestBody CompanyReportQueryInfo companyReportQueryInfo) {
        PageBean<CompanyReportModel> result = companyReportService.findByQueryInfo(companyReportQueryInfo);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
