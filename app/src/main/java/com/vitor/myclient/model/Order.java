package com.vitor.myclient.model;

import java.util.Date;

public class Order {

    private String clientName;
    private String clientPhone;
    private Float orderPrice;
    private String orderDate;

    public Order(String clientName, String clientPhone, Float orderPrice, String orderDate) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }
}
