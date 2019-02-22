package com.ling.springcloud_user.controller;

import com.ling.springcloud_user.entity.Order;
import com.ling.springcloud_user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private OrderService orderInterface;
    
    @RequestMapping("order")
    @ResponseBody
    public Order  getOrderInfo(){
        return orderInterface.getOrderInfo();
    }
    
}
