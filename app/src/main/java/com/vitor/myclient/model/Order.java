package com.vitor.myclient.model;

import java.util.Date;

public class Order {

    private String clientName;
    private String clientPhone;
    private Double orderPrice;
    private Date orderDate;

    public Order(String clientName, String clientPhone, Double orderPrice, Date orderDate) {
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

    public Double getOrderPrice() {
        return orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
