package com.sarva.springbootcarapptdd.nonreactive;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

	Car findByMake(String make);
	
}
