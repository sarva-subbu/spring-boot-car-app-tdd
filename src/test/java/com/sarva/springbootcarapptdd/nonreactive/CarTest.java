package com.sarva.springbootcarapptdd.nonreactive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.sarva.springbootcarapptdd.nonreactive.Car;

public class CarTest {

	@Test
	public void shouldCarHaveMakeAndModelAndYear() {
		Car car = new Car("toyota", "corolla", 2015);
		assertThat(car).isNotNull();
		assertThat(car.getMake()).isEqualTo("toyota");
		assertThat(car.getModel()).isEqualTo("corolla");
		assertThat(car.getYear()).isEqualTo(2015);
	}
	
}
