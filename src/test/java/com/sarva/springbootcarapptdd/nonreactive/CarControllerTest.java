package com.sarva.springbootcarapptdd.nonreactive;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	@Test
	public void shouldReturnCar() throws Exception {
		given(carService.getCar(anyString())).willReturn(new Car("123", "toyota", "corolla", 2015));

		mockMvc.perform(get("/cars/{make}", "toyota")).andExpect(status().isOk())
				// .andExpect(jsonPath("$[0].make").value("toyota"));
				.andExpect(jsonPath("$.make").value("toyota"));
	}

}
