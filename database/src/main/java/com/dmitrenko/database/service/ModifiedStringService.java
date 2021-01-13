package com.dmitrenko.database.service;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;

import java.util.List;

public interface ModifiedStringService {

	ModifiedStringResponse addModifiedString(ModifiedStringRequest request);

	List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request);

	ModifiedStringResponse getModifiedString(Long modifiedStringId);

	List<ModifiedStringResponse> getAllModifiedStrings();

	ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringRequest request);

	boolean deleteModifiedString(Long modifiedStringId);

	boolean deleteAllModifiedStrings();
}
