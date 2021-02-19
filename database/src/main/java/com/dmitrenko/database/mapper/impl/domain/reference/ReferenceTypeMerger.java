package com.dmitrenko.database.mapper.impl.domain.reference;

import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceTypeMerger implements Merger<ReferenceType, ReferenceTypeRequest> {

	@Override
	public ReferenceType merge(ReferenceType target, ReferenceTypeRequest source) {
		return target
			.setName(source.getName())
			.setDescription(source.getDescription());
	}
}
