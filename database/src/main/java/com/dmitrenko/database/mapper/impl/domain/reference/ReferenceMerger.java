package com.dmitrenko.database.mapper.impl.domain.reference;

import com.dmitrenko.database.domain.reference.Reference;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceMerger implements Merger<Reference, ReferenceRequest> {

	@Override
	public Reference merge(Reference target, ReferenceRequest source) {
		return target
			.setName(source.getName())
			.setType(new ReferenceType(source.getTypeId()));
	}
}
