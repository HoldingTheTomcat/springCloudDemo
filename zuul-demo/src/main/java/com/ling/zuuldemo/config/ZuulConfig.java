package com.ling.zuuldemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @author TianHeLing
 * @Description 路由配置动态注入，它对应的原配置类org.springframework.cloud.netflix.zuul.filters.ZuulProperties
 * @date 2019/3/19
 */
@Component
public class ZuulConfig {
    
    
    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();    
    }
    
}
