package com.ling.springcloud_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient //开启Eureka客户端功能
@SpringBootApplication
public class SpringcloudUserApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringcloudUserApplication.class, args);
	}
	
	@Bean
	@LoadBalanced //负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
