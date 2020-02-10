package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.DiagnosisCountModel;
import com.gsafety.dawn.enterprise.manage.contract.model.ReportedPersonInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api", tags = "ExternalAccess Api")
public class ExternalAccessController {

    @Autowired
    private ExternalAccessService ExternalAccessService;

    @GetMapping(value = "/enterprise/reportedPersonsInfo/{reportedDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "所有已填报人员信息", notes = "getReportedPersonsInfo()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DiagnosisCountModel.class,responseContainer = "List" ),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<ReportedPersonInfoModel>> getReportedPersonsInfo() {
        List<ReportedPersonInfoModel> result = ExternalAccessService.getReportedPersonsInfo();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
