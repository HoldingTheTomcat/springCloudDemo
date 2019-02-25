package com.ling.springcloud_user.service.impl;

import com.ling.springcloud_user.dao.OrderClient;
import com.ling.springcloud_user.entity.Order;
import com.ling.springcloud_user.service.OrderService;
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

    @Autowired
    private OrderClient orderClient;

    //使用feignClient方式调用服务
    @Override
    public Order getOrderInfo() {
        Order order = orderClient.getOrder();
        return order;
    }
    
}
