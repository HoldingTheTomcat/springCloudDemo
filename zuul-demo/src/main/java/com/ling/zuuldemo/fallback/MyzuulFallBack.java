package com.ling.zuuldemo.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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

            /**
             * 状态码另外一种说法
             * 
             * 网关向 api 服务请求失败了，但是消费者客户端向网关发起的请求是成功的，
             * 不应该把 api 的 404,500 等问题抛给客户端
             * 网关和 api 服务集群对于客户端来说是黑盒
             * 即返回状态码ok 
             */
            
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

            //即返回正常
            // @Override
            // public InputStream getBody() throws IOException {
            //     ObjectMapper objectMapper = new ObjectMapper();
            //     Map<String, Object> map = new HashMap<>();
            //     map.put("status", 200);
            //     map.put("message", "无法连接，请检查您的网络");
            //     return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
            // }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
