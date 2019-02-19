package com.ling.springcloud_user.config;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LingZi on 2018/11/25.
 */
@Configuration
public class FeignClientConfig2 {

    /*
        配置要输出的日志是那些，必须在debug模式下才可以输出 
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.DEBUG;
    }

    
    /*
        feign 默认使用的是spring mvc 注解，加上这个注解就可以使用RequestLine
     */
    /*@Bean
    public Contract feignConfiguration() {
        return new feign.Contract.Default();
    }*/

    

   
}
