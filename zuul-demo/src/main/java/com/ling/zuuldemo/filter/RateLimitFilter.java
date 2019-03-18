package com.ling.zuuldemo.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author TianHeLing
 * @Description
 * @date 2019/3/19
 */
public class RateLimitFilter extends ZuulFilter {

    private static final RateLimiter limiter = RateLimiter.create(100);
    
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //如果没有拿到令牌
        if(!limiter.tryAcquire()){
            throw new RuntimeException();
        }
        return null;
    }
}
