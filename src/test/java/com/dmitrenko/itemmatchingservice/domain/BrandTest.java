package com.dmitrenko.itemmatchingservice.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest extends BaseEntityTest{

	private final Long ID = 1L;
	private final String NAME = "NAME";
	private final LocalDateTime CREATED = LocalDateTime.now();
	private final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

	@BeforeAll
	public void init() throws ClassNotFoundException {
		checkNumberOfFields(4);
	}

	@Test
	void testNoArgsConstructor() {
		var entity = getEntity();

		assertEquals(ID, entity.getId());
		assertEquals(NAME, entity.getName());
		assertEquals(CREATED, entity.getCreatedDateTime());
		assertEquals(MODIFIED, entity.getModifiedDateTime());

		var entity2 = new Brand(-ID);
		assertEquals(-ID, entity2.getId());
	}

	private Brand getEntity() {
		return new Brand()
			.setId(ID)
			.setName(NAME)
			.setCreatedDateTime(CREATED)
			.setModifiedDateTime(MODIFIED);
	}
}