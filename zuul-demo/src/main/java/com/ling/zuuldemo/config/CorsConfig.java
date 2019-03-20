package com.ling.zuuldemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域配置
 * C - Cross  O - Origin  R - Resource  S - Sharing  跨域资源共享
 */
@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("*")); //http:www.a.com
		config.setAllowedHeaders(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("*")); //get、put...
		//缓存时间，在这个时间段里，对于相同的跨域请求，就不再进行检查
		config.setMaxAge(300l); //300秒

		//指定跨域的路径，/** 对所有请求
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
