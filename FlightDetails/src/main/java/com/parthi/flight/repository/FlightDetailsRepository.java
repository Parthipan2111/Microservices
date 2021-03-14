package com.parthi.flight.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parthi.flight.entity.FlightDetails;
@Repository
public interface FlightDetailsRepository extends MongoRepository<FlightDetails, String> {

}
