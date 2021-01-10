package com.dmitrenko.transferapi.service;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesAddRequest;
import com.dmitrenko.database.dto.request.company.CompanyAddRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeAddRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeUpdateRequest;
import com.dmitrenko.database.dto.request.company.CompanyUpdateRequest;
import com.dmitrenko.database.dto.request.item.CurrencyAddRequest;
import com.dmitrenko.database.dto.request.item.CurrencyUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemAddRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeAddRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
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
import com.dmitrenko.transferapi.wrapper.ListResponse;
import com.dmitrenko.transferapi.wrapper.ObjectResponse;

public interface TransferApiService {

	ObjectResponse<BrandNameResponse> addBrandName(BrandNameRequest request);

	ListResponse<BrandNameResponse> addBrandNames(BrandNamesAddRequest request);

	ObjectResponse<BrandNameResponse> getBrandName(Long brandNameId);

	ListResponse<BrandNameResponse> getAllBrandNames();

	ObjectResponse<BrandNameResponse> updateBrandName(Long brandNameId, BrandNameRequest request);

	void deleteBrandName(Long brandNameId);

	void deleteAllBrandNames();

	ObjectResponse<CompanyResponse> addCompany(CompanyAddRequest request);

	ObjectResponse<CompanyResponse> getCompany(Long companyId);

	ListResponse<CompanyResponse> getAllCompanies();

	ObjectResponse<CompanyResponse> updateCompany(Long companyId, CompanyUpdateRequest request);

	void deleteCompany(Long companyId);

	ObjectResponse<CompanyTypeResponse> addCompanyType(CompanyTypeAddRequest request);

	ObjectResponse<CompanyTypeResponse> getCompanyType(Long typeId);

	ListResponse<CompanyTypeResponse> getAllCompanyTypes();

	ObjectResponse<CompanyTypeResponse> updateCompanyType(Long typeId, CompanyTypeUpdateRequest request);

	void deleteCompanyType(Long companyId);

	ObjectResponse<ItemResponse> addItem(ItemAddRequest request);

	ListResponse<ItemResponse> addItems(ItemsAddRequest request);

	ObjectResponse<ItemResponse> getItem(Long itemId);

	ListResponse<ItemResponse> getAllItemsByCompany(Long companyId);

	ObjectResponse<ItemResponse> updateItem(Long itemId, ItemUpdateRequest request);

	void deleteItem(Long itemId);

	void deleteAllItemsByCompany(Long companyId);

	ObjectResponse<ItemTypeResponse> addItemType(ItemTypeAddRequest request);

	ObjectResponse<ItemTypeResponse> getItemType(Long typeId);

	ListResponse<ItemTypeResponse> getAllItemTypes();

	ObjectResponse<ItemTypeResponse> updateItemType(Long typeId, ItemTypeUpdateRequest request);

	void deleteItemType(Long typeId);

	ObjectResponse<CurrencyResponse> addCurrency(CurrencyAddRequest request);

	ObjectResponse<CurrencyResponse> getCurrency(Long currencyId);

	ListResponse<CurrencyResponse> getAllCurrencies();

	ObjectResponse<CurrencyResponse> updateCurrency(Long currencyId, CurrencyUpdateRequest request);

	void deleteCurrency(Long currencyId);

	ObjectResponse<ModifiedStringResponse> addModifiedString(ModifiedStringAddRequest request);

	ListResponse<ModifiedStringResponse> addModifiedStrings(ModifiedStringsAddRequest request);

	ObjectResponse<ModifiedStringResponse> getModifiedString(Long modifiedStringId);

	ListResponse<ModifiedStringResponse> getAllModifiedStrings();

	ObjectResponse<ModifiedStringResponse> updateModifiedString(Long modifiedStringId, ModifiedStringUpdateRequest request);

	void deleteModifiedString(Long modifiedStringId);

	void deleteAllModifiedStrings();

	ObjectResponse<ReferenceResponse> addReference(ReferenceAddRequest request);

	ObjectResponse<ReferenceResponse> getReference(Long referenceId);

	ListResponse<ReferenceResponse> getAllReferences();

	ObjectResponse<ReferenceResponse> updateReference(Long referenceId, ReferenceUpdateRequest request);

	void deleteReference(Long referenceId);

	ObjectResponse<ReferenceTypeResponse> addReferenceType(ReferenceTypeAddRequest request);

	ObjectResponse<ReferenceTypeResponse> getReferenceType(Long typeId);

	ListResponse<ReferenceTypeResponse> getAllReferenceTypes();

	ObjectResponse<ReferenceTypeResponse> updateReferenceType(Long typeId, ReferenceTypeUpdateRequest request);

	void deleteReferenceType(Long companyId);

	ObjectResponse<ReferenceFieldResponse> addReferenceField(ReferenceFieldAddRequest request);

	ListResponse<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsAddRequest request);

	ObjectResponse<ReferenceFieldResponse> getReferenceField(Long fieldId);

	ListResponse<ReferenceFieldResponse> getAllReferenceFields();

	ObjectResponse<ReferenceFieldResponse> updateReferenceField(Long typeId, ReferenceFieldUpdateRequest request);

	ListResponse<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	void deleteReferenceField(Long fieldId);

	void deleteReferenceFields(ReferenceFieldsDeleteRequest request);

	void deleteAllReferenceFieldsByReferenceId(Long referenceId);

	ObjectResponse<UserResponse> addUser(UserAddRequest request);

	ObjectResponse<UserResponse> getUser(Long userId);

	ListResponse<UserResponse> getAllUsers();

	ObjectResponse<UserResponse> updateUser(Long userId, UserUpdateRequest request);

	void deleteUser(Long userId);
}
