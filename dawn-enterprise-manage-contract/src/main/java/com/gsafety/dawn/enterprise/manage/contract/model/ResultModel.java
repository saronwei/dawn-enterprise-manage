package com.gsafety.dawn.enterprise.manage.contract.model;

public class ResultModel<T> {
    private T data;

    private long total;

    public ResultModel() {
    }

    public ResultModel(T data, long total) {
        this.data = data;
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
