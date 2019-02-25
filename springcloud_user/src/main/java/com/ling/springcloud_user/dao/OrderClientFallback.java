package com.ling.springcloud_user.dao;

import com.ling.springcloud_user.entity.Order;
import org.springframework.stereotype.Component;

/**
 * @author TianHeLing
 * @Description 对OrderClient的熔断保护
 * @date 2019/2/25
 */
@Component
public class OrderClientFallback implements OrderClient {
    @Override
    public Order getOrder() {
        Order order = new Order();
        order.setName("订单查询出现异常");
        return order;
    }
}
