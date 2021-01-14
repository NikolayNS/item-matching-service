package com.dmitrenko.database.mapper.impl.domain.reference;

import com.dmitrenko.database.domain.reference.Reference;
import com.dmitrenko.database.domain.reference.ReferenceField;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldUpdateRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceFieldUpdateMerger implements Merger<ReferenceField, ReferenceFieldUpdateRequest> {

	@Override
	public ReferenceField merge(ReferenceField target, ReferenceFieldUpdateRequest source) {
		return target
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setReference(new Reference(source.getReferenceId()));
	}
}
