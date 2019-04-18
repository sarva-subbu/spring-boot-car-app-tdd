package com.sarva.springbootcarapptdd.nonreactive;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

	@Id
	@Generated
	private String id;
	
	private String make;
	
	private String model;
	
	private int year;

}
