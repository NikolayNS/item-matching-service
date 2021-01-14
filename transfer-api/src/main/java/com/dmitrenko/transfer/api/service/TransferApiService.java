package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.request.item.CurrencyAddRequest;
import com.dmitrenko.database.dto.request.item.CurrencyUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemAddRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeAddRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.dto.request.user.UserAddRequest;
import com.dmitrenko.database.dto.request.user.UserUpdateRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.database.dto.response.item.CurrencyResponse;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface TransferApiService {

	ObjectResponse<BrandNameResponse> addBrandName(BrandNameRequest request);

	ListResponse<BrandNameResponse> addBrandNames(BrandNamesRequest request);

	ObjectResponse<BrandNameResponse> getBrandName(Long brandNameId);

	ListResponse<BrandNameResponse> getAllBrandNames();

	ObjectResponse<BrandNameResponse> updateBrandName(Long brandNameId, BrandNameRequest request);

	SuccessWrapper deleteBrandName(Long brandNameId);

	SuccessWrapper deleteAllBrandNames();

	ObjectResponse<CompanyResponse> addCompany(CompanyRequest request);

	ObjectResponse<CompanyResponse> getCompany(Long companyId);

	ListResponse<CompanyResponse> getAllCompanies();

	ObjectResponse<CompanyResponse> updateCompany(Long companyId, CompanyRequest request);

	SuccessWrapper deleteCompany(Long companyId);

	ObjectResponse<CompanyTypeResponse> addCompanyType(CompanyTypeRequest request);

	ObjectResponse<CompanyTypeResponse> getCompanyType(Long typeId);

	ListResponse<CompanyTypeResponse> getAllCompanyTypes();

	ObjectResponse<CompanyTypeResponse> updateCompanyType(Long typeId, CompanyTypeRequest request);

	SuccessWrapper deleteCompanyType(Long companyId);

	ObjectResponse<ItemResponse> addItem(ItemAddRequest request);

	ListResponse<ItemResponse> addItems(ItemsAddRequest request);

	ObjectResponse<ItemResponse> getItem(Long itemId);

	ListResponse<ItemResponse> getAllItemsByCompany(Long companyId);

	ObjectResponse<ItemResponse> updateItem(Long itemId, ItemUpdateRequest request);

	SuccessWrapper deleteItem(Long itemId);

	SuccessWrapper deleteAllItemsByCompany(Long companyId);

	ObjectResponse<ItemTypeResponse> addItemType(ItemTypeAddRequest request);

	ObjectResponse<ItemTypeResponse> getItemType(Long typeId);

	ListResponse<ItemTypeResponse> getAllItemTypes();

	ObjectResponse<ItemTypeResponse> updateItemType(Long typeId, ItemTypeUpdateRequest request);

	SuccessWrapper deleteItemType(Long typeId);

	ObjectResponse<CurrencyResponse> addCurrency(CurrencyAddRequest request);

	ObjectResponse<CurrencyResponse> getCurrency(Long currencyId);

	ListResponse<CurrencyResponse> getAllCurrencies();

	ObjectResponse<CurrencyResponse> updateCurrency(Long currencyId, CurrencyUpdateRequest request);

	SuccessWrapper deleteCurrency(Long currencyId);

	ObjectResponse<ModifiedStringResponse> addModifiedString(ModifiedStringRequest request);

	ListResponse<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request);

	ObjectResponse<ModifiedStringResponse> getModifiedString(Long modifiedStringId);

	ListResponse<ModifiedStringResponse> getAllModifiedStrings();

	ObjectResponse<ModifiedStringResponse> updateModifiedString(Long modifiedStringId, ModifiedStringRequest request);

	SuccessWrapper deleteModifiedString(Long modifiedStringId);

	SuccessWrapper deleteAllModifiedStrings();

	ObjectResponse<ReferenceResponse> addReference(ReferenceRequest request);

	ObjectResponse<ReferenceResponse> getReference(Long referenceId);

	ListResponse<ReferenceResponse> getAllReferences();

	ObjectResponse<ReferenceResponse> updateReference(Long referenceId, ReferenceRequest request);

	SuccessWrapper deleteReference(Long referenceId);

	ObjectResponse<ReferenceTypeResponse> addReferenceType(ReferenceTypeRequest request);

	ObjectResponse<ReferenceTypeResponse> getReferenceType(Long typeId);

	ListResponse<ReferenceTypeResponse> getAllReferenceTypes();

	ObjectResponse<ReferenceTypeResponse> updateReferenceType(Long typeId, ReferenceTypeRequest request);

	SuccessWrapper deleteReferenceType(Long typeId);

	ObjectResponse<ReferenceFieldResponse> addReferenceField(ReferenceFieldRequest request);

	ListResponse<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request);

	ObjectResponse<ReferenceFieldResponse> getReferenceField(Long fieldId);

	ListResponse<ReferenceFieldResponse> getAllReferenceFields();

	ObjectResponse<ReferenceFieldResponse> updateReferenceField(Long typeId, ReferenceFieldRequest request);

	ListResponse<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	SuccessWrapper deleteReferenceField(Long fieldId);

	SuccessWrapper deleteAllReferenceFieldsByReferenceId(Long referenceId);

	ObjectResponse<UserResponse> addUser(UserAddRequest request);

	ObjectResponse<UserResponse> getUser(Long userId);

	ListResponse<UserResponse> getAllUsers();

	ObjectResponse<UserResponse> updateUser(Long userId, UserUpdateRequest request);

	SuccessWrapper deleteUser(Long userId);
}
