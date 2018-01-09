package com.sarva.springbootcarapptdd.nonreactive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sarva.springbootcarapptdd.nonreactive.Car;
import com.sarva.springbootcarapptdd.nonreactive.CarRepository;
import com.sarva.springbootcarapptdd.nonreactive.CarService;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

	@Mock
	private CarRepository carRepository;

	@Test
	public void shouldReturnCar() {
		// arrange
		given(carRepository.findByMake(anyString())).willReturn(new Car("toyota", "corolla", 2015));

		// act
		CarService service = new CarService(carRepository);
		Car car = service.getCar("toyota");

		// assert
		assertThat(car).isNotNull();
		assertThat(car.getMake()).isEqualTo("toyota");
	}

	@Test
	public void shouldNotReturnCar() {
		// arrange
		given(carRepository.findByMake(anyString())).willReturn(null);

		// act
		CarService service = new CarService(carRepository);
		Car car = service.getCar("honda");

		// assert
		assertThat(car).isNull();
	}

}
