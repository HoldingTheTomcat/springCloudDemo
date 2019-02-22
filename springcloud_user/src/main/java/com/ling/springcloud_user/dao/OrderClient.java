package com.ling.springcloud_user.dao;

import com.ling.springcloud_user.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author TianHeLing
 * @Description 将来feign底层会用动态代理的方式，帮我们实现这个接口
 * @date 2019/2/22
 */
@FeignClient("spring-cloud-order")
@RequestMapping("order")
public interface OrderClient {

    @RequestMapping("getOne")
    @ResponseBody
    Order getOrder();
    
}
