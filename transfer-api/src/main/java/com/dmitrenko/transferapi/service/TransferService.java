package com.dmitrenko.transferapi.service;

import com.dmitrenko.database.dto.request.brandname.BrandNameAddRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNameUpdateRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesAddRequest;
import com.dmitrenko.database.dto.request.company.CompanyAddRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeAddRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeUpdateRequest;
import com.dmitrenko.database.dto.request.company.CompanyUpdateRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringAddRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringUpdateRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsDeleteRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceUpdateRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;

import java.util.List;

public interface TransferService {

	BrandNameResponse addBrandName(BrandNameAddRequest request);

	List<BrandNameResponse> addBrandNames(BrandNamesAddRequest request);

	BrandNameResponse getBrandName(Long brandNameId);

	List<BrandNameResponse> getAllBrandNames();

	BrandNameResponse updateBrandName(Long brandNameId, BrandNameUpdateRequest request);

	void deleteBrandName(Long brandNameId);

	void deleteAllBrandNames();

	CompanyResponse addCompany(CompanyAddRequest request);

	CompanyResponse getCompany(Long companyId);

	List<CompanyResponse> getAllCompanies();

	CompanyResponse updateCompany(Long companyId, CompanyUpdateRequest request);

	void deleteCompany(Long companyId);

	CompanyTypeResponse addCompanyType(CompanyTypeAddRequest request);

	CompanyTypeResponse getCompanyType(Long typeId);

	List<CompanyTypeResponse> getAllCompanyTypes();

	CompanyTypeResponse updateCompanyType(Long typeId, CompanyTypeUpdateRequest request);

	void deleteCompanyType(Long companyId);

	ReferenceResponse addReference(ReferenceAddRequest request);

	ReferenceResponse getReference(Long referenceId);

	List<ReferenceResponse> getAllReferences();

	ReferenceResponse updateReference(Long referenceId, ReferenceUpdateRequest request);

	void deleteReference(Long referenceId);

	ReferenceTypeResponse addReferenceType(ReferenceTypeAddRequest request);

	ReferenceTypeResponse getReferenceType(Long typeId);

	List<ReferenceTypeResponse> getAllReferenceTypes();

	ReferenceTypeResponse updateReferenceType(Long typeId, ReferenceTypeUpdateRequest request);

	void deleteReferenceType(Long companyId);

	ReferenceFieldResponse addReferenceField(ReferenceFieldAddRequest request);

	List<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsAddRequest request);

	ReferenceFieldResponse getReferenceField(Long fieldId);

	List<ReferenceFieldResponse> getAllReferenceFields();

	ReferenceFieldResponse updateReferenceField(Long typeId, ReferenceFieldUpdateRequest request);

	List<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	void deleteReferenceField(Long fieldId);

	void deleteReferenceFields(ReferenceFieldsDeleteRequest request);

	void deleteAllReferenceFieldsByReferenceId(Long referenceId);

	ModifiedStringResponse addModifiedString(ModifiedStringAddRequest request);

	List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsAddRequest request);

	ModifiedStringResponse getModifiedString(Long modifiedStringId);

	List<ModifiedStringResponse> getAllModifiedStrings();

	ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringUpdateRequest request);

	void deleteModifiedString(Long modifiedStringId);

	void deleteAllModifiedStrings();
}
