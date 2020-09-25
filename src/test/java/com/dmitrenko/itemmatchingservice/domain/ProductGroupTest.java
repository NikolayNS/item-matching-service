package com.dmitrenko.itemmatchingservice.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductGroupTest extends BaseEntityTest{

	private final Long ID = 1L;
	private final Long INDEX = 1L;
	private final String NAME = "NAME";
	private final LocalDateTime CREATED = LocalDateTime.now();
	private final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

	@BeforeAll
	public void init() throws ClassNotFoundException {
		checkNumberOfFields(6);
	}

	@Test
	void testNoArgsConstructor() {
		var entity = getEntity();

		assertEquals(ID, entity.getId());
		assertEquals(INDEX, entity.getGroupIndex());
		assertEquals(NAME, entity.getName());
		assertEquals(CREATED, entity.getCreatedDateTime());
		assertEquals(MODIFIED, entity.getModifiedDateTime());

		var entity2 = new ProductGroup(-ID);
		assertEquals(-ID, entity2.getId());
	}

	private ProductGroup getEntity() {
		return new ProductGroup()
			.setId(ID)
			.setGroupIndex(INDEX)
			.setName(NAME)
			.setCreatedDateTime(CREATED)
			.setModifiedDateTime(MODIFIED);
	}
}