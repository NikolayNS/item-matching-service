package com.dmitrenko.database.mapper.impl.domain.modifiedstring;

import com.dmitrenko.database.domain.modifedstring.ModifiedString;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifiedStringMapper implements Mapper<ModifiedString, ModifiedStringRequest> {

	@Override
	public ModifiedString from(ModifiedStringRequest source) {
		return new ModifiedString()
			.setModifiable(source.getModifiable())
			.setModifying(source.getModifying());
	}
}
