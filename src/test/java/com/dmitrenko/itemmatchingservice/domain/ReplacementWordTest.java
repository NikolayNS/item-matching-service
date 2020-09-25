package com.dmitrenko.itemmatchingservice.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReplacementWordTest extends BaseEntityTest{

	private final Long ID = 1L;
	private final String REPLACEABLE = "REPLACEABLE";
	private final String REPLACEMENT = "REPLACEMENT";
	private final LocalDateTime CREATED = LocalDateTime.now();
	private final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

	@BeforeAll
	public void init() throws ClassNotFoundException {
		checkNumberOfFields(5);
	}

	@Test
	void testNoArgsConstructor() {
		var entity = getEntity();

		assertEquals(ID, entity.getId());
		assertEquals(REPLACEABLE, entity.getReplaceable());
		assertEquals(REPLACEMENT, entity.getReplacement());
		assertEquals(CREATED, entity.getCreatedDateTime());
		assertEquals(MODIFIED, entity.getModifiedDateTime());

		var entity2 = new ReplacementWord(-ID);
		assertEquals(-ID, entity2.getId());
	}

	private ReplacementWord getEntity() {
		return new ReplacementWord()
			.setId(ID)
			.setReplaceable(REPLACEABLE)
			.setReplacement(REPLACEMENT)
			.setCreatedDateTime(CREATED)
			.setModifiedDateTime(MODIFIED);
	}
}