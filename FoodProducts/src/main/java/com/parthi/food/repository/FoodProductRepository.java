package com.parthi.food.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parthi.food.entity.FoodProduct;
@Repository
public interface FoodProductRepository extends MongoRepository<FoodProduct,	String>{

}
