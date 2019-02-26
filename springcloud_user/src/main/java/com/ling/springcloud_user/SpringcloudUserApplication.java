package com.ling.springcloud_user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //开启声明式调用
@SpringCloudApplication //组合注解@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker

public class SpringcloudUserApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringcloudUserApplication.class, args);
	}
}
