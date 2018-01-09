package com.sarva.springbootcarapptdd.nonreactive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sarva.springbootcarapptdd.nonreactive.Car;
import com.sarva.springbootcarapptdd.nonreactive.CarRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CarIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private CarRepository carRepository;

	@Before
	public void setUp() {
		carRepository.deleteAll();
		carRepository.save(new Car("toyota", "corolla", 2015));
	}

	@After
	public void tearDown() {
		carRepository.deleteAll();
	}

	@Test
	public void shouldReturnCarByMake() {
		ResponseEntity<Car> responseEntity = restTemplate.getForEntity("/cars/{make}", Car.class, "toyota");
		Car car = responseEntity.getBody();
		assertThat(car).isNotNull();
		assertThat(car.getMake()).isEqualTo("toyota");
	}

}
