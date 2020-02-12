package com.gsafety.dawn.enterprise.manage.webapi.controller;

import com.gsafety.dawn.enterprise.manage.contract.model.*;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseInfoService;
import com.gsafety.java.common.exception.HttpError;
import com.gsafety.java.common.page.PageBean;
import com.gsafety.springboot.common.annotation.LimitIPRequestAnnotation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Enterprise info controller.
 */
@Api(value = "/api/v1", tags = "企业基本信息 Api")
@RestController
@RequestMapping("/api/v1")
public class EnterpriseInfoController {
    /**
     * The Enterprise info service.
     */
    @Autowired
    EnterpriseInfoService enterpriseInfoService;

    /**
     * Gets enterprise info by id.
     *
     * @param id the id
     * @return the enterprise info by id
     */
    @ApiOperation(value = "按企业Id查询企业基本信息")
    @ApiResponses({
            @ApiResponse(code = 204, message = "查询成功", response = Boolean.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @GetMapping(value = "/enterprise-info/id/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity getEnterpriseInfoById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                enterpriseInfoService.getEnterpriseInfoById(id));
    }

    /**
     * Gets enterprise info by ant id.
     *
     * @param antId the ant id
     * @return the enterprise info by ant id
     */
    @ApiOperation(value = "按租户Id查询企业基本信息")
    @ApiResponses({
            @ApiResponse(code = 204, message = "查询成功", response = Boolean.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @GetMapping(value = "/enterprise-info/antId/{antId}", produces = "application/json;charset=UTF-8")
    public ResponseEntity getEnterpriseInfoByAntId(@PathVariable("antId") String antId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                enterpriseInfoService.getEnterpriseInfoByAntId(antId));
    }

    /**
     * Gets enterprise simple infos.
     *
     * @return the enterprise simple infos
     */
    @ApiOperation(value = "查询所有企业简单信息(调用方式同分页，目前只查Id和name)")
    @ApiResponses({
            @ApiResponse(code = 204, message = "查询成功", response = Boolean.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @PostMapping(value = "/enterprise-simple-info", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<EnterpriseSimpleInfo>> getEnterpriseSimpleInfos(@RequestBody EnterpriseInfoQueryInfo queryInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(
                enterpriseInfoService.getEnterpriseSimpleInfos(queryInfo));
    }

    /**
     * Gets enterprise info model by page.
     *
     * @param queryInfo the query info
     * @return the enterprise info model by page
     */
    @ApiOperation(value = "分页(支持查所有)", notes = "getEnterpriseInfoModelByPage()")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    @PostMapping("/enterprises/info/search")
    public ResponseEntity<PageBean<EnterpriseInfoModel>> getEnterpriseInfoModelByPage(@RequestBody EnterpriseInfoQueryInfo queryInfo) {
        PageBean<EnterpriseInfoModel> result = enterpriseInfoService.getEnterpriseInfoModelByPage(queryInfo);
        return ResponseEntity.ok(result);
    }

    /**
     * Save enterprise info response entity.
     *
     * @param model the model
     * @return the response entity
     */
    @PostMapping(value = "/enterprise-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "新增/修改企业基本信息", notes = "saveEnterpriseInfo(model)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DailyTroubleshootRecordModel.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpError.class),
            @ApiResponse(code = 406, message = "Not Acceptable", response = HttpError.class)})
    @LimitIPRequestAnnotation(limitCounts = 10, timeSecond = 1000)
    public ResponseEntity<EnterpriseInfoModel> saveEnterpriseInfo(
            @RequestBody @ApiParam(value = "企业基本信息", required = true) EnterpriseInfoModel model) {
        EnterpriseInfoModel result =
                enterpriseInfoService.saveEnterpriseInfoModel(model);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Del enterprise info by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @ApiOperation(value = "删除企业基本信息")
    @ApiResponses({
            @ApiResponse(code = 204, message = "删除成功", response = Boolean.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @DeleteMapping(value = "/enterprise-info/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity delEnterpriseInfoById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                enterpriseInfoService.delEnterpriseInfoById(id));
    }
}
