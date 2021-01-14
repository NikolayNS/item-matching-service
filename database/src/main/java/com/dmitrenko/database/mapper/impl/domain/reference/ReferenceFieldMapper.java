package com.dmitrenko.database.mapper.impl.domain.reference;

import com.dmitrenko.database.domain.reference.Reference;
import com.dmitrenko.database.domain.reference.ReferenceField;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceFieldMapper implements Mapper<ReferenceField, ReferenceFieldRequest> {

	@Override
	public ReferenceField from(ReferenceFieldRequest source) {
		return new ReferenceField()
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setReference(new Reference(source.getReferenceId()));
	}
}
