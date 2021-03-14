package com.parthi.flight.model;

public class FlightDetailRequest {
	
	private String source;
	private String destination;
	private String cost;
	
	public FlightDetailRequest() {
	}
	
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
	
	

}
