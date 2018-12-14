package com.ling.springcloud_user.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

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
        return Logger.Level.FULL;
    }

    
    /*
        feign 默认使用的是spring mvc 注解，加上这个注解就可以使用RequestLine
     */
    /*@Bean
    public Contract feignConfiguration() {
        return new feign.Contract.Default();
    }*/

    

   
}
