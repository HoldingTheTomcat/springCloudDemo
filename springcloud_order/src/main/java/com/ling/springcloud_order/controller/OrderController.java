package com.ling.springcloud_order.controller;

import com.ling.springcloud_order.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
@RequestMapping("order")
@RefreshScope
public class OrderController {


    @Value("${ip}")
    private String name;

    // @Value("${ipport}")
    private String ipport;
    
     private Logger logger = LoggerFactory.getLogger(getClass());
    
    @PostMapping("getOne")
    public Order getOrder(HttpServletRequest request) throws InterruptedException {
        logger.info("服务调用请求.....");
        int localPort = request.getLocalPort();
        // // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        // Thread.sleep(2000);
        Order order = new Order();
        order.setName("ling:"+ ipport);
        logger.info("name:{}", name);
        logger.info("ipport:{}", ipport);
        return order;
    }
}
