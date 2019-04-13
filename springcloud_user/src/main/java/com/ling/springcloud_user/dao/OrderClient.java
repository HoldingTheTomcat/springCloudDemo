package com.ling.springcloud_user.dao;

import com.ling.springcloud_user.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author TianHeLing
 * @Description 将来feign底层会用动态代理的方式，帮我们实现这个接口
 * @date 2019/2/22
 */
@FeignClient(value = "springcloud-order",path = "order" ,fallbackFactory = OrderClientFallbackFactory.class)
public interface OrderClient {

    @RequestMapping(value = "getOne",method = RequestMethod.GET)
    Order getOrder(@RequestParam("name") String name);
    
}
