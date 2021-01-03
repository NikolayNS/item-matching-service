package com.dmitrenko.transferapi.controller;

import com.dmitrenko.database.dto.request.reference.ReferenceAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsDeleteRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.transferapi.service.TransferService;
import com.dmitrenko.transferapi.wrapper.ListResponse;
import com.dmitrenko.transferapi.wrapper.ObjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class ReferenceController {

	public static final String REFERENCE_ADD = "/api/v1/reference";
	public static final String REFERENCES = "/api/v1/references";
	public static final String REFERENCE = "/api/v1/reference/{referenceId}";
	public static final String REFERENCE_TYPE_ADD = "/api/v1/reference-type";
	public static final String REFERENCE_TYPES = "/api/v1/reference-types";
	public static final String REFERENCE_TYPE = "/api/v1/reference-type/{typeId}";
	public static final String REFERENCE_FIELD_ADD = "/api/v1/reference-field";
	public static final String REFERENCE_FIELDS = "/api/v1/reference-fields";
	public static final String REFERENCE_FIELD = "/api/v1/reference-field/{fieldId}";

	private final TransferService transferService;

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference")
	public ObjectResponse<ReferenceResponse> addReference(@RequestBody ReferenceAddRequest request) {
		return ObjectResponse.success(transferService.addReference(request));
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get reference by id")
	public ObjectResponse<ReferenceResponse> getReference(@PathVariable Long referenceId) {
		return ObjectResponse.success(transferService.getReference(referenceId));
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all references")
	public ListResponse<ReferenceResponse> getAllReferences() {
		return ListResponse.success(transferService.getAllReferences());
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update reference by id")
	public ObjectResponse<ReferenceResponse> updateReference(@PathVariable Long referenceId,
															 @RequestBody ReferenceUpdateRequest request) {
		return ObjectResponse.success(transferService.updateReference(referenceId, request));
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete reference by id")
	public void deleteReference(@PathVariable Long referenceId) {
		transferService.deleteReference(referenceId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_TYPE_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference type")
	public ObjectResponse<ReferenceTypeResponse> addReferenceType(@RequestBody ReferenceTypeAddRequest request) {
		return ObjectResponse.success(transferService.addReferenceType(request));
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get reference type by id")
	public ObjectResponse<ReferenceTypeResponse> getReferenceType(@PathVariable Long typeId) {
		return ObjectResponse.success(transferService.getReferenceType(typeId));
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE_TYPES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all reference types")
	public ListResponse<ReferenceTypeResponse> getAllReferenceTypes() {
		return ListResponse.success(transferService.getAllReferenceTypes());
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update reference type by id")
	public ObjectResponse<ReferenceTypeResponse> updateReferenceType(@PathVariable Long typeId,
																	 @RequestBody ReferenceTypeUpdateRequest request) {
		return ObjectResponse.success(transferService.updateReferenceType(typeId, request));
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE_TYPE, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete reference type by id")
	public void deleteReferenceType(@PathVariable Long typeId) {
		transferService.deleteReferenceType(typeId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_FIELD_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference field")
	public ObjectResponse<ReferenceFieldResponse> addReferenceField(@RequestBody ReferenceFieldAddRequest request) {
		return ObjectResponse.success(transferService.addReferenceField(request));
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference fields")
	public ListResponse<ReferenceFieldResponse> addReferenceFields(@RequestBody ReferenceFieldsAddRequest request) {
		return ListResponse.success(transferService.addReferenceFields(request));
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE_FIELD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get reference field by id")
	public ObjectResponse<ReferenceFieldResponse> getReferenceField(@PathVariable Long fieldId) {
		return ObjectResponse.success(transferService.getReferenceField(fieldId));
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all reference fields")
	public ListResponse<ReferenceFieldResponse> getAllReferenceFields() {
		return ListResponse.success(transferService.getAllReferenceFields());
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE_FIELD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update reference field by id")
	public ObjectResponse<ReferenceFieldResponse> updateReferenceField(@PathVariable Long fieldId,
																	   @RequestBody ReferenceFieldUpdateRequest request) {
		return ObjectResponse.success(transferService.updateReferenceField(fieldId, request));
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update all reference fields")
	public ListResponse<ReferenceFieldResponse> updateReferenceFields(@RequestBody ReferenceFieldsUpdateRequest request) {
		return ListResponse.success(transferService.updateReferenceFields(request));
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE_FIELD, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete reference field by id")
	public void deleteReferenceField(@PathVariable Long fieldId) {
		transferService.deleteReferenceField(fieldId);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete reference fields by ids")
	public void deleteReferenceFields(@RequestBody ReferenceFieldsDeleteRequest request) {
		transferService.deleteReferenceFields(request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete all reference fields by reference id")
	public void deleteAllReferenceFieldsByReferenceId(@PathVariable Long referenceId) {
		transferService.deleteAllReferenceFieldsByReferenceId(referenceId);
	}
}
