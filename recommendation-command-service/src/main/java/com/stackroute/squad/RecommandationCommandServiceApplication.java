package com.stackroute.squad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class RecommandationCommandServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(RecommandationCommandServiceApplication.class, args);
	}

}
