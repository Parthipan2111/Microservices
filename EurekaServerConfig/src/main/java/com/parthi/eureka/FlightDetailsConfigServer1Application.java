package com.parthi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableEurekaServer
public class FlightDetailsConfigServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(FlightDetailsConfigServer1Application.class, args);
	}

}
