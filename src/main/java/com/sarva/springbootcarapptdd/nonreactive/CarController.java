package com.sarva.springbootcarapptdd.nonreactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	private CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/cars/{make}")
	public Car getCars(@PathVariable String make) {
		return carService.getCar(make);
	}
	
}
