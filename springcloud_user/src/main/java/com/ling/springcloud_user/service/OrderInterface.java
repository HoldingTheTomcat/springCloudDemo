package com.ling.springcloud_user.service;

import com.ling.springcloud_user.config.FeignClientConfig2;
import com.ling.springcloud_user.entity.Order;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LingZi on 2018/11/24.
 */
@FeignClient(name = "SPRINGCLOUDORDER",configuration = FeignClientConfig2.class,url = "http://localhost:6872",fallbackFactory = OrderInterface.FeignClientFallbackFactory.class)
public interface OrderInterface {

    @PostMapping(value = "ling")
    Order getOrder3();

    @Component
    public class FeignClientFallbackFactory implements FallbackFactory<OrderInterface> {

        public static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

        @Override
        public OrderInterface create(Throwable throwable) {
            return new OrderInterface() {

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

    @RequestMapping(value = "ling/{id}", method = RequestMethod.GET)
    Order getOrderInfo(@PathVariable("id") String id);

  /*  @RequestMapping("GET /ling")
    Order getOrder();*/

    @PostMapping(value = "ling")
    Order getOrder2(Order order);//如果你传递的是复杂参数，那么feign不管你配置的是什么请求方式，都会以post方式发出去，所以这里访问不到

    
    /* @RequestLine("GET /ling/{id}") //组合注解，第一个是请求方式，第二个参数，用空格分隔
    Order getOrder3(@Param("id") String id);//注意，使用RequestLine的时候必须使用@Param注解*/
}
