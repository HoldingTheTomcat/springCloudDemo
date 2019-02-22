package com.ling.springcloud_order.controller;

import com.ling.springcloud_order.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
@RequestMapping("order")
public class OrderController {
    
     private Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("getOne")
    @ResponseBody
    public Order getOrder() throws InterruptedException {
        logger.info("服务调用请求.....");
        
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        Thread.sleep(new Random().nextInt(2000));
        
        Order order = new Order();
        order.setName("ling");
        return order;
    }
}
