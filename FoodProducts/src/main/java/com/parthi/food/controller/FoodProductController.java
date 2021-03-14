package com.parthi.food.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parthi.food.entity.FoodProduct;
import com.parthi.food.model.FoodProductRequest;
import com.parthi.food.services.FoodProductService;
import org.slf4j.*;

@RestController
public class FoodProductController {
	
	Logger log = LoggerFactory.getLogger(FoodProductController.class);
	@Autowired
	private FoodProductService service;
	
	@GetMapping("/getAllFoodProduct/{name}")
	public ResponseEntity<List<FoodProduct>> getFoodProducts(@PathVariable String name){
		if(name.equalsIgnoreCase("parthi")) {
			throw new RuntimeException("Exception occured");
		}
		List<FoodProduct> products=service.getProducts();
		log.info("inside food service");
		return new ResponseEntity<List<FoodProduct>>(products,HttpStatus.ACCEPTED);	
	}
	
	@PostMapping("/updateProduct")
	public ResponseEntity<String> saveProduct(@RequestBody FoodProductRequest request) {
		String result = service.saveFood(request);
		if(result.equalsIgnoreCase("success")) {
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		}else {
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
