package com.ling.springcloud_order.controller;

import com.ling.springcloud_order.entity.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
public class OrderController {
    
    
    @RequestMapping("ling")
    @ResponseBody
    public Order getOrder(){
        Order order = new Order();
        order.setName("ling");
        System.out.println("lingge");
        return order;
    }
}
