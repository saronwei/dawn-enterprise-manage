package com.gsafety.dawn.enterprise.manage.contract.model;

import io.swagger.annotations.ApiModelProperty;
import org.drools.core.util.StringUtils;

public class Result<T> {
    private static final String SUCCESS_CODE = "000000";
    private static final String FAIL_CODE = "999999";
    @ApiModelProperty("是否成功（true:成功，false:失败）")
    private boolean success;
    @ApiModelProperty("状态码（可选）")
    private String code = "000000";
    @ApiModelProperty("提示消息")
    private String msg;
    @ApiModelProperty("响应数据")
    private T data;

    public String getCode() {
        if (StringUtils.isEmpty(this.code)) {
            if (this.success) {
                this.code = "000000";
            } else {
                this.code = "999999";
            }
        }

        return this.code;
    }

    public static <T> Result.ResultBuilder<T> builder() {
        return new Result.ResultBuilder();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Result(final boolean success, final String code, final String msg, final T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public static class ResultBuilder<T> {
        private boolean success;
        private String code;
        private String msg;
        private T data;

        ResultBuilder() {
        }

        public Result.ResultBuilder<T> success(final boolean success) {
            this.success = success;
            return this;
        }

        public Result.ResultBuilder<T> code(final String code) {
            this.code = code;
            return this;
        }

        public Result.ResultBuilder<T> msg(final String msg) {
            this.msg = msg;
            return this;
        }

        public Result.ResultBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public Result<T> build() {
            return new Result(this.success, this.code, this.msg, this.data);
        }

        public String toString() {
            return "Result.ResultBuilder(success=" + this.success + ", code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
        }
    }
}
