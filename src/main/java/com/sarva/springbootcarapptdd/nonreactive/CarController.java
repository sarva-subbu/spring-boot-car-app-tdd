package com.sarva.springbootcarapptdd.nonreactive;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/cars/{make}/cache")
	public Car getCarsCache(@PathVariable String make) {
		return carService.getCarCache(make);
	}

	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}

	@GetMapping("/cars")
	public List<Car> getCars() {
		return carService.getCars();
	}

}
