package com.sarva.springbootcarapptdd.nonreactive;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CacheTest {

	@Autowired
	private CarService carService;

	@MockBean
	private CarRepository carRepository;

	@Test
	public void shouldReturnCarFromCache() {
		given(carRepository.findByMake(anyString())).willReturn(new Car("123", "hyundai", "verna", 2015));
		carService.getCar("hyundai");
		carService.getCar("hyundai");
		verify(carRepository, times(1)).findByMake(anyString());
	}

	@Test
	public void shouldNotReturnCarFromCache() {
		given(carRepository.findByMake(anyString())).willReturn(new Car("123", "toyota", "corolla", 2015));
		carService.getCar("toyota");
		carService.getCar("honda");
		verify(carRepository, times(2)).findByMake(anyString());
	}

}
