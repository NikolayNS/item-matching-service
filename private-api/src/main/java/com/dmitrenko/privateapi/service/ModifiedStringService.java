package com.dmitrenko.privateapi.service;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;

public interface ModifiedStringService {

	ObjectResponse<ModifiedStringResponse> addModifiedString(ModifiedStringRequest request);

	ListResponse<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request);

	ObjectResponse<ModifiedStringResponse> getModifiedString(Long modifiedStringId);

	ListResponse<ModifiedStringResponse> getAllModifiedStrings();

	ObjectResponse<ModifiedStringResponse> updateModifiedString(Long modifiedStringId, ModifiedStringRequest request);

	SuccessWrapper deleteModifiedString(Long modifiedStringId);

	SuccessWrapper deleteAllModifiedStrings();
}
