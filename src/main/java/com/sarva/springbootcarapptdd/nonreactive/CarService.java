package com.sarva.springbootcarapptdd.nonreactive;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarService {

	private CarRepository carRepository;

	private CarService carService;

	public CarService(CarRepository repository, CarService carService) {
		this.carRepository = repository;
		this.carService = carService;
	}

	@Cacheable("car-by-make")
	public Car getCarCache(String make) {
		System.out.println("get car on the service [cached]");
		return carRepository.findByMake(make);
	}

	public Car getCar(String make) {
		System.out.println("get car on the service");
		return carService.getCarCache(make);
	}

	public List<Car> getCars() {
		return carRepository.findAll();
	}

	public Car addCar(Car car) {
		return carRepository.save(car);
	}

}
