package com.dmitrenko.itemmatchingservice.controller;

import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.BrandResponse;
import com.dmitrenko.itemmatchingservice.service.BrandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.dmitrenko.itemmatchingservice.controller.BrandController.BRAND_ADD;
import static com.dmitrenko.itemmatchingservice.controller.BrandController.BRAND_DELETE;
import static com.dmitrenko.itemmatchingservice.controller.BrandController.BRAND_DELETE_ALL;
import static com.dmitrenko.itemmatchingservice.controller.BrandController.BRAND_GET;
import static com.dmitrenko.itemmatchingservice.controller.BrandController.BRAND_GET_ALL;
import static com.dmitrenko.itemmatchingservice.controller.BrandController.BRAND_UPDATE;
import static com.dmitrenko.itemmatchingservice.utils.Constant.ISO_DATE_TIME_PATTERN;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BrandControllerTest {

	private final Long ID = 1L;
	private final String NAME = "NAME";
	private final LocalDateTime CREATED = LocalDateTime.now();
	private final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ISO_DATE_TIME_PATTERN);

	private MockMvc mvc;

	@InjectMocks
	private BrandController controller;

	@Mock
	private BrandService service;

	@BeforeEach
	public void initMock() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void add() throws Exception{
		when(service.add(any())).thenReturn(getResponse());

		mvc
			.perform(post(BRAND_ADD)
				.accept(APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(getAddRequest()))
				.contentType(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.message", is("")))
			.andExpect(jsonPath("$.data.id", is(ID.intValue())))
			.andExpect(jsonPath("$.data.name", is(NAME)))
			.andExpect(jsonPath("$.data.created", is(CREATED.format(formatter))))
			.andExpect(jsonPath("$.data.modified", is(MODIFIED.format(formatter))));

		verify(service).add(any());
		verifyNoMoreInteractions(service);
	}

	private BrandResponse getResponse() {
		return new BrandResponse()
			.setId(ID)
			.setName(NAME)
			.setCreated(CREATED)
			.setModified(MODIFIED);
	}

	private BrandAddRequest getAddRequest() {
		return new BrandAddRequest()
			.setName(NAME);
	}

	@Test
	void get() throws Exception{
		when(service.get(any())).thenReturn(getResponse());

		mvc
			.perform(post(BRAND_GET)
				.accept(APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(getGetRequest()))
				.contentType(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.message", is("")))
			.andExpect(jsonPath("$.data.id", is(ID.intValue())))
			.andExpect(jsonPath("$.data.name", is(NAME)))
			.andExpect(jsonPath("$.data.created", is(CREATED.format(formatter))))
			.andExpect(jsonPath("$.data.modified", is(MODIFIED.format(formatter))));

		verify(service).get(any());
		verifyNoMoreInteractions(service);
	}

	private BrandGetRequest getGetRequest() {
		return new BrandGetRequest()
			.setId(ID);
	}

	@Test
	void getAll() throws Exception{
		when(service.getAll()).thenReturn(List.of(getResponse()));

		mvc
			.perform(post(BRAND_GET_ALL)
				.accept(APPLICATION_JSON_VALUE)
				.contentType(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.message", is("")))
			.andExpect(jsonPath("$.data[0].id", is(ID.intValue())))
			.andExpect(jsonPath("$.data[0].name", is(NAME)))
			.andExpect(jsonPath("$.data[0].created", is(CREATED.format(formatter))))
			.andExpect(jsonPath("$.data[0].modified", is(MODIFIED.format(formatter))));

		verify(service).getAll();
		verifyNoMoreInteractions(service);
	}

	@Test
	void update() throws Exception{
		when(service.update(any())).thenReturn(getResponse());

		mvc
			.perform(post(BRAND_UPDATE)
				.accept(APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(getUpdateRequest()))
				.contentType(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.message", is("")))
			.andExpect(jsonPath("$.data.id", is(ID.intValue())))
			.andExpect(jsonPath("$.data.name", is(NAME)))
			.andExpect(jsonPath("$.data.created", is(CREATED.format(formatter))))
			.andExpect(jsonPath("$.data.modified", is(MODIFIED.format(formatter))));

		verify(service).update(any());
		verifyNoMoreInteractions(service);
	}

	private BrandUpdateRequest getUpdateRequest() {
		return new BrandUpdateRequest()
			.setId(ID)
			.setName(NAME);
	}

	@Test
	void delete() throws Exception{
		mvc
			.perform(post(BRAND_DELETE)
				.accept(APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(getDeleteRequest()))
				.contentType(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.message", is("Brand with ID: " + ID + " was deleted")));

		verify(service).delete(any());
		verifyNoMoreInteractions(service);
	}

	private BrandDeleteRequest getDeleteRequest() {
		return new BrandDeleteRequest()
			.setId(ID);
	}

	@Test
	void deleteAll() throws Exception{
		mvc
			.perform(post(BRAND_DELETE_ALL)
				.accept(APPLICATION_JSON_VALUE)
				.contentType(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.message", is("All Brands was deleted")));

		verify(service).deleteAll();
		verifyNoMoreInteractions(service);
	}
}