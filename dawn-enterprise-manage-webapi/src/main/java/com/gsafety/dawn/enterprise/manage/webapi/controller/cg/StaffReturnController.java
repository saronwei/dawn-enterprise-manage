package com.gsafety.dawn.enterprise.manage.webapi.controller.cg;

import com.gsafety.dawn.enterprise.manage.contract.model.*;
import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.DailyTroubleshootRecordService;
import com.gsafety.dawn.enterprise.manage.contract.service.cm.StaffReturnService;
import com.gsafety.dawn.enterprise.manage.service.entity.cg.CompanyReportInfoEntity;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@Api(value = "/api", tags = "Staff Return Report Api")
public class StaffReturnController {

    @Autowired
    StaffReturnService staffReturnService;

    @PostMapping(value = "/staff-return-reports/{page}/{pageSize}")
    @ApiOperation(value = "分页", notes = "queryStaffReturnReportsPage()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<ResultModel<List<StaffReturnInfoModel>>> queryStaffReturnReportsPage(@PathVariable@ApiParam(value = "page", required = true)  int page , @PathVariable @ApiParam(value = "pageSize", required = true) int pageSize) {
        TotalStatisticsQuery tq = new TotalStatisticsQuery();
        // tq.setEnterpriseCode("company-0001");
        tq.setEnterpriseName("北京辰安信息科技有限公司");
        Map<String, Object> rrr = staffReturnService.queryStaffReturnReportsPage(tq, PageRequest.of(page, pageSize));

        List<StaffReturnInfoModel> aa = (List<StaffReturnInfoModel>)rrr.get("list");
        long bb = Long.valueOf(String.valueOf(rrr.get("total")));
        return ResponseEntity.ok(new ResultModel<List<StaffReturnInfoModel>>(aa, bb));
    }

    @PostMapping(value = "/staff-return-report/get/{id}")
    @ApiOperation(value = "人员详情", notes = "queryStaffReturnReportsPage()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<StaffReturnInfoModel> getStaffInfo(@PathVariable  @ApiParam(value = "员工Id", required = true) String id) {
        StaffReturnInfoModel result = staffReturnService.getStaffInfo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
