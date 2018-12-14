package com.ling.springcloud_user.controller;

import com.ling.springcloud_user.entity.Order;
import com.ling.springcloud_user.service.OrderInterface;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("info")
    @ResponseBody
    public String  info(){
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("SPRINGCLOUDORDER", false);
        return nextServerFromEureka.getHomePageUrl();
    }

    @RequestMapping("info2")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "fallMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")})
    public Order info2() {
        Order forObject = this.restTemplate.getForObject("http://SPRINGCLOUDORDER/ling", Order.class);
        return forObject;
    }
    
    public Order fallMethod(){
        Order order = new Order();
        order.setName("haha");
        return order;
    }

    @Autowired
    private OrderInterface orderInterface;
    
    @RequestMapping("info3")
    @ResponseBody
    public Order info3(){
        Order order3 = orderInterface.getOrder3();
        return order3;
    }
    
}
