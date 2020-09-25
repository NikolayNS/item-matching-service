package com.dmitrenko.itemmatchingservice.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CompanyItemTest extends BaseEntityTest {

	private final Long ID = 1L;
	private final String BARCODE = "BARCODE";
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
		assertEquals(BARCODE, entity.getBarcode());
		assertEquals(NAME, entity.getName());
		assertNotNull(entity.getProductGroup());
		assertEquals(CREATED, entity.getCreatedDateTime());
		assertEquals(MODIFIED, entity.getModifiedDateTime());

		var entity2 = new CompanyItem(-ID);
		assertEquals(-ID, entity2.getId());
	}

	private CompanyItem getEntity() {
		return new CompanyItem()
			.setId(ID)
			.setBarcode(BARCODE)
			.setName(NAME)
			.setProductGroup(new ProductGroup())
			.setCreatedDateTime(CREATED)
			.setModifiedDateTime(MODIFIED);
	}
}