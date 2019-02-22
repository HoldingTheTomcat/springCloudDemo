/*
package com.ling.springcloud_user.factory;

import com.ling.springcloud_user.entity.Order;
import com.ling.springcloud_user.service.OrderService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*/
/**
 * 该类需实现FallbackFactory接口，并覆写create方法
 *//*

public class FeignClientFallbackFactory2 implements FallbackFactory<OrderService>{

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory2.class);
    @Override
    public OrderService create(Throwable throwable) {
        return new OrderService() {

            @Override
            public Order getOrder3() {
                LOGGER.info("fallback; reason was:", throwable);//记录失败原因
                Order order = new Order();
                order.setName("出错了");
                return order;
            }

            @Override
            public Order getOrderInfo(String id) {
                LOGGER.info("fallback; reason was:", throwable);//记录失败原因
                Order order = new Order();
                order.setName("出错了");
                return order;
            }

            @Override
            public Order getOrder2(Order order) {
                LOGGER.info("fallback; reason was:", throwable);
                return null;
            }
        };
    }
}
*/
