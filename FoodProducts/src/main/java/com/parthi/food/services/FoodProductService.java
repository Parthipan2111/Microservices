package com.parthi.food.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.parthi.food.entity.FoodProduct;
import com.parthi.food.model.FoodProductRequest;
import com.parthi.food.repository.FoodProductRepository;

@Service
public class FoodProductService {
	
	@Autowired
	FoodProductRepository foodProductRepository;
	
	@Autowired
	Environment env;
	
	
	public List<FoodProduct> getProducts(){
		return foodProductRepository.findAll();
	}

public String saveFood(FoodProductRequest request) {
		
		ModelMapper mapper = new ModelMapper();
		String result = "";
		FoodProduct fp =mapper.map(request, FoodProduct.class);
		fp.setProductCompany(env.getProperty("product.company"));
		try {
		foodProductRepository.save(fp);
			result = "success";
		}catch(Exception e) {
			result = "fail";
		}
		return result; 
}
}
