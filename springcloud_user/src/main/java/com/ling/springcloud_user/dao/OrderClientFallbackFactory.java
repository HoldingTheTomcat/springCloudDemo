package com.ling.springcloud_user.dao;

import com.ling.springcloud_user.entity.Order;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author TianHeLing
 * @Description 对OrderClient的熔断保护
 * @date 2019/2/25
 */
@Component
public class OrderClientFallbackFactory implements FallbackFactory<OrderClient> {
    
 private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public OrderClient create(Throwable throwable) {
        return new OrderClient() {
            @Override
            public Order getOrder(String name) {
                logger.info("错误:{}", throwable);
                Order order = new Order();
                order.setName("订单查询出现异常222");
                return order;
            }
        };
    }
}
