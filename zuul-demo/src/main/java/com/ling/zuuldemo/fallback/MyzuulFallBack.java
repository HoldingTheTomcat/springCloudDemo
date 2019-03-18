package com.ling.zuuldemo.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TianHeLing
 * @Description
 * @date 2019/3/18
 */
@Component
public class MyzuulFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        return "springcloud-order"; //指定为哪个服务做熔断  *表示所有
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {//Throwable异常原因
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {//响应码，正常应该根据异常等判断
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {//对应的错误描述
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {
            
            }

            //返回的正文
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("出现错误" + getRoute()).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
