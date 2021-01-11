package com.dmitrenko.database.mapper.impl.domain.modifiedstring;

import com.dmitrenko.database.domain.modifedstring.ModifiedString;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifiedStringMerger implements Merger<ModifiedString, ModifiedStringRequest> {

	@Override
	public ModifiedString merge(ModifiedString target, ModifiedStringRequest source) {
		return target
			.setModifiable(source.getModifiable())
			.setModifying(source.getModifying());
	}
}
