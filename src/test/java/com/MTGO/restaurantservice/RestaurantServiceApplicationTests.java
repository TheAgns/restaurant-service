package com.MTGO.restaurantservice;

import com.MTGO.restaurantservice.dto.MenuItemRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Disabled
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class RestaurantServiceApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
@Autowired
private MockMvc mockMvc;
@Autowired
private ObjectMapper objectMapper;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void shouldCreateMenuItem() throws Exception {
		MenuItemRequest menuItemRequest = getMenuItemRequest();
		String menuItemRequestString = objectMapper.writeValueAsString(menuItemRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/menuItem")
						.param("restaurantId", "6554c6178dc83b51ed4e7414")
				.contentType(MediaType.APPLICATION_JSON)
				.content(menuItemRequestString))
				.andExpect(status().isCreated());
	}

	private MenuItemRequest getMenuItemRequest() {
		return MenuItemRequest.builder()
				.name("trabilsaktor")
				.description("asdasd")
				.price(BigDecimal.valueOf(2222))
				.build();
	}

}
