package com.dmitrenko.database.service.domain.modifiedstring;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;

import java.util.List;

public interface ModifiedStringDomainService {

	ModifiedStringResponse addModifiedString(ModifiedStringRequest request);

	List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request);

	ModifiedStringResponse getModifiedString(Long modifiedStringId);

	List<ModifiedStringResponse> getAllModifiedStrings();

	ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringRequest request);

	void deleteModifiedString(Long modifiedStringId);

	void deleteAllModifiedStrings();
}
