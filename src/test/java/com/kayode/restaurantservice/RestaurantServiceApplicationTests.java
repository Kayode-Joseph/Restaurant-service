package com.kayode.restaurantservice;


import com.kayode.restaurantservice.services.RestaurantService;
import com.kayode.restaurantservice.web.dtos.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.RestaurantResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class RestaurantServiceApplicationTests {

	@Container
	static MySQLContainer mySQLContainer= new MySQLContainer<>("mysql:latest");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private RestaurantService restaurantService;


	ObjectMapper objectMapper= new ObjectMapper();

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.datasource.url",mySQLContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", mySQLContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", mySQLContainer::getPassword);
	}

	@Test
	void shouldCreateRestaurant() throws Exception {

		var createRestaurantRequest= getRestaurant();

		String createRestaurantRequestAsJson= objectMapper.writeValueAsString(createRestaurantRequest);

		callCreateRestaurantEndpoint(createRestaurantRequestAsJson).andExpect(status().isCreated());


	}

	@Test
	void shouldGetRestaurants() throws Exception{

		restaurantService.createRestaurant(getRestaurant());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurant/")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));

	}

	@Test
	void getOneRestaurant() throws Exception {

		RestaurantResponse restaurantResponse= restaurantService.createRestaurant(getRestaurant());

		final String UUID= String.valueOf(restaurantResponse.getPublicId());

		final String URL="/api/restaurant/"+UUID;

		mockMvc.perform(MockMvcRequestBuilders.get(URL)).andExpect(status().isOk());

	}

	private RestaurantRequest getRestaurant() {
	return 	RestaurantRequest.builder().name("Axis Foods")
				.address("123 watery lane")
				.latitude(10)
				.longitude(20)
				.build();
	}

	private ResultActions callCreateRestaurantEndpoint(String createRestaurantRequestAsJson) throws Exception {

		return mockMvc.perform(MockMvcRequestBuilders.post("/api/restaurant/create")
						.contentType(MediaType.APPLICATION_JSON).content(createRestaurantRequestAsJson));


	}

}
