package com.gsafety.dawn.enterprise.manage.contract.model;

public class Data<T> {
    private T list;

    private long total;

    public Data() {
    }

    public Data(T list, long total) {
        this.list = list;
        this.total = total;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
