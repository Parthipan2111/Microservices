package com.parthi.flight.model;

import java.util.List;

public class FlightDetailsResponse {
	
	private String source;
	private String destination;
	private String cost;
	private List<FoodProduct> foodProducts;
	
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public List<FoodProduct> getFoodProducts() {
		return foodProducts;
	}
	public void setFoodProducts(List<FoodProduct> foodProducts) {
		this.foodProducts = foodProducts;
	}
	
	

}
