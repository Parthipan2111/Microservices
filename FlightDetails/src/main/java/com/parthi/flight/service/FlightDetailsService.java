package com.parthi.flight.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.parthi.flight.entity.FlightDetails;
import com.parthi.flight.model.FlightDetailRequest;
import com.parthi.flight.model.FlightDetailsResponse;
import com.parthi.flight.model.FoodProduct;
import com.parthi.flight.repository.FlightDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
//@RibbonClient(name = "flightribbon")
public class FlightDetailsService {
	
	Logger log = LoggerFactory.getLogger(FlightDetailsService.class);
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private RestTemplate restTemplates;
	
	@Autowired
	private Environment env;
	
	
	@HystrixCommand(fallbackMethod = "getFlightsFallback")
	public List<FlightDetailsResponse> getFlights(String name){
		//log.info("===========Actual Method=========",name);
		List<FlightDetails> flightDetails = flightDetailsRepository.findAll();
	
		ResponseEntity<FoodProduct[]> response=restTemplates.getForEntity("http://FOODPRODUCTSMS"+"/getAllFoodProduct/"+name, FoodProduct[].class);
		FoodProduct[] body = response.getBody();
		List<FoodProduct> asList = Arrays.asList(body);
		List<FlightDetailsResponse> result = new ArrayList<FlightDetailsResponse>();
		flightDetails.forEach(flights ->{
			FlightDetailsResponse fr= new FlightDetailsResponse();
			fr.setCost(flights.getCost());
			fr.setDestination(flights.getDestination());
			fr.setSource(flights.getSource());
			fr.setFoodProducts(asList);
			result.add(fr);
		});
		return result;
	}
	public List<FlightDetailsResponse> getFlightsFallback(String name){
		log.info("===========fall back Method=========",name);

		return new ArrayList<FlightDetailsResponse>();
	}

	
	
	public String saveFlight(FlightDetailRequest request) {
		
		ModelMapper mapper = new ModelMapper();
		String result = "";
		FlightDetails fd =mapper.map(request, FlightDetails.class);
		try {
		flightDetailsRepository.save(fd);
			result = "success";
		}catch(Exception e) {
			result = "fail";
		}
		return result;
	}
	


}
