package com.ling.springcloud_order.controller;

import com.ling.springcloud_order.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
public class OrderController {
    
     private Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("ling")
    @ResponseBody
    public Order getOrder(){
        logger.info("服务调用请求.....");
        Order order = new Order();
        order.setName("ling");
        return order;
    }
}
