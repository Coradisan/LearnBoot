package com.pkfare.entity;

/**
 * 测试Pyton接口时，从txt读入得数据
 */
public class ReqDataEntity {

    protected String carrier;//航司
    protected String departure;//起点
    protected String arriver;//终点
    protected String departureDate;//出发时间

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArriver() {
        return arriver;
    }

    public void setArriver(String arriver) {
        this.arriver = arriver;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "ReqDataEntity{" +
                "carrier='" + carrier + '\'' +
                ", departure='" + departure + '\'' +
                ", arriver='" + arriver + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
