package com.parthi.flight.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.parthi.flight.model.FlightDetailRequest;
import com.parthi.flight.model.FlightDetailsResponse;
import com.parthi.flight.service.FlightDetailsService;


@RestController
public class FlightController {
	
	Logger log = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	FlightDetailsService services;
	
	@GetMapping("/flights")
	public ResponseEntity<List<FlightDetailsResponse>> getAllFlights(@RequestParam(required = false) String name){
		List<FlightDetailsResponse> flights=services.getFlights(name);
		return new ResponseEntity<List<FlightDetailsResponse>>(flights,HttpStatus.ACCEPTED);	
	}
	
	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@RequestBody FlightDetailRequest request) {
		String result = services.saveFlight(request);
		if(result.equalsIgnoreCase("success")) {
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
		}else {
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
