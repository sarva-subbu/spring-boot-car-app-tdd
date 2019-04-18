package com.sarva.springbootcarapptdd.nonreactive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;

	@Before
	public void setUp() {
		carRepository.deleteAll();
		carRepository.save(new Car("123", "toyota", "corolla", 2015));
	}

	@After
	public void tearDown() {
		carRepository.deleteAll();
	}

	@Test
	public void shouldReturnCarByMake() {
		Car car = carRepository.findByMake("toyota");
		assertThat(car).isNotNull();
		assertThat(car.getMake()).isEqualTo("toyota");
	}

}
