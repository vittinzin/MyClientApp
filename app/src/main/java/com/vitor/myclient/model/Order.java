package com.vitor.myclient.model;

import java.util.Date;

public class Order {

    private String clientName;
    private String clientPhone;
    private Float orderPrice;
    private Date orderDate;

    public Order(String clientName, String clientPhone, Float orderPrice, Date orderDate) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
