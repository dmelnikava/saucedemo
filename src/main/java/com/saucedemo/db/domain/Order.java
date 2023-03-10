package com.saucedemo.db.domain;

import java.util.List;

public class Order {

    private Long id;
    private String paymentInfo;
    private String shippingInfo;
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", shippingInfo='" + shippingInfo + '\'' +
                ", items=" + items +
                '}';
    }
}