package com.ling.springcloud_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient //开启Eureka客户端功能
@EnableHystrix //开启熔断保护
@EnableFeignClients //开启声明式调用
@SpringBootApplication
public class SpringcloudUserApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringcloudUserApplication.class, args);
	}
}
