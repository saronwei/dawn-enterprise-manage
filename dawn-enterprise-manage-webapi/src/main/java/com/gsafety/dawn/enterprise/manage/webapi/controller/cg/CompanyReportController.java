package com.gsafety.dawn.enterprise.manage.webapi.controller.cg;

import com.gsafety.dawn.enterprise.manage.service.entity.cg.CompanyReportInfoEntity;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @outhor xingek
 * @create 2020-02-10 13:05
 */
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api", tags = "Company Report Api")
public class CompanyReportController {

    @GetMapping(value = "/company-reports/{page}/{pageSize}")
    @ApiOperation(value = "分页", notes = "queryCompanyReportsPage()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<List<CompanyReportInfoEntity>> queryCompanyReportsPage(@PathVariable @ApiParam(value = "page", required = true)  int page , @PathVariable @ApiParam(value = "pageSize", required = true) int pageSize) {
        List<CompanyReportInfoEntity> result = new ArrayList<>();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
