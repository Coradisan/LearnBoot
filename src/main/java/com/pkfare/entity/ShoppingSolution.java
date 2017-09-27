package com.pkfare.entity;

/**
 * Created by Admin on 2017/8/10 0010.
 */
public class ShoppingSolution {

    private Integer id;
    private String reqId;//AK.HKG.BKK.2017-09-19.OW
    private String times;//第几次请求
    private String shoppingSolution;
    private String listSize;//shopping是否空集合 0 空, 1 非空
    private String usetimes;//耗时

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getShoppingSolution() {
        return shoppingSolution;
    }

    public void setShoppingSolution(String shoppingSolution) {
        this.shoppingSolution = shoppingSolution;
    }

    public String getListSize() {
        return listSize;
    }

    public void setListSize(String listSize) {
        this.listSize = listSize;
    }

    public String getTimes() {
        return times;
    }

    public String getUsetimes() {
        return usetimes;
    }

    public void setUsetimes(String usetimes) {
        this.usetimes = usetimes;
    }
}
