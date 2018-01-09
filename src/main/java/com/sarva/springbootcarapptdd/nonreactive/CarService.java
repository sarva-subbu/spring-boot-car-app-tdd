package com.sarva.springbootcarapptdd.nonreactive;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	private CarRepository carRepository;

	public CarService(CarRepository repository) {
		this.carRepository = repository;
	}

	@Cacheable("car-by-make")
	public Car getCar(String make) {
		return carRepository.findByMake(make);
	}

}
