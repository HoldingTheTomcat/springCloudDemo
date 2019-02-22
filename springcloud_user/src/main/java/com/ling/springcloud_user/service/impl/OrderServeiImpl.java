package com.ling.springcloud_user.service.impl;

import com.ling.springcloud_user.entity.Order;
import com.ling.springcloud_user.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author TianHeLing
 * @Description
 * @date 2019/2/22
 */

@Service
public class OrderServeiImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    //使用restTemplate方式调用服务
    @HystrixCommand(fallbackMethod = "getOrderInfoFallback")  //超时，触发熔断
    public Order getOrderInfo() {
        Order forObject = this.restTemplate.getForObject("http://SPRINGCLOUDORDER/ling", Order.class);
        return forObject;
    }
    
    //熔断响应
    public Order getOrderInfoFallback(){
        Order order = new Order();
        order.setName("哈哈，熔断跳闸");
        return order;
    }
    
}
