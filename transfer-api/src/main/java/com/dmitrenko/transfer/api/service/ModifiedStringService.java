package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface ModifiedStringService {

	ObjectResponse<ModifiedStringResponse> addModifiedString(ModifiedStringRequest request);

	ListResponse<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request);

	ObjectResponse<ModifiedStringResponse> getModifiedString(Long modifiedStringId);

	ListResponse<ModifiedStringResponse> getAllModifiedStrings();

	ObjectResponse<ModifiedStringResponse> updateModifiedString(Long modifiedStringId, ModifiedStringRequest request);

	SuccessWrapper deleteModifiedString(Long modifiedStringId);

	SuccessWrapper deleteAllModifiedStrings();
}
