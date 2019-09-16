package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderProfileServiceApplication.class, args);
	}

}
