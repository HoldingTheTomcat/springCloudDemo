package com.ling.springcloud_order.entity;

/**
 * Created by LingZi on 2018/11/24.
 */
public class Order {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                '}';
    }
}
