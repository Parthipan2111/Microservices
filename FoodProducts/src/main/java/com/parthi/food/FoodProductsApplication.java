package com.parthi.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodProductsApplication.class, args);
	}

}
