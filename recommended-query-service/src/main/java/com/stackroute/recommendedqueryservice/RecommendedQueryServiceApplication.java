package com.stackroute.recommendedqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RecommendedQueryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecommendedQueryServiceApplication.class, args);
	}

}
