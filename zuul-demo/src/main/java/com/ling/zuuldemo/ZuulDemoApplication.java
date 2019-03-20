package com.ling.zuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //开启Zuul的网关的代理路由功能,自带熔断、自动注册到eureka(需要添加eureka的依赖)
public class ZuulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class, args);
    }

    

    // //版本号方式映射
    // @Bean
    // public PatternServiceRouteMapper serviceRouteMapper() {
    //     return new PatternServiceRouteMapper(
    //             "(?<name>^.+)-(?<version>v.+$)",
    //             "${version}/${name}");
    // }
}
