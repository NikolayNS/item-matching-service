package com.dmitrenko.transfer.api.service.impl;

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
import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.dto.request.user.UserRequest;
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
import com.dmitrenko.database.service.BrandNameService;
import com.dmitrenko.database.service.CompanyService;
import com.dmitrenko.database.service.ItemService;
import com.dmitrenko.database.service.ModifiedStringService;
import com.dmitrenko.database.service.ReferenceService;
import com.dmitrenko.database.service.UserService;
import com.dmitrenko.transfer.api.service.TransferApiService;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferApiServiceImpl implements TransferApiService {

	private final BrandNameService brandNameService;
	private final CompanyService companyService;
	private final ItemService itemService;
	private final ModifiedStringService modifiedStringService;
	private final ReferenceService referenceService;
	private final UserService userService;

	@Override
	public ObjectResponse<BrandNameResponse> addBrandName(BrandNameRequest request) {
		return ObjectResponse.success(brandNameService.addBrandName(request));
	}

	@Override
	public ListResponse<BrandNameResponse> addBrandNames(BrandNamesRequest request) {
		return ListResponse.success(brandNameService.addBrandNames(request));
	}

	@Override
	public ObjectResponse<BrandNameResponse> getBrandName(Long brandNameId) {
		return ObjectResponse.success(brandNameService.getBrandName(brandNameId));
	}

	@Override
	public ListResponse<BrandNameResponse> getAllBrandNames() {
		return ListResponse.success(brandNameService.getAllBrandNames());
	}

	@Override
	public ObjectResponse<BrandNameResponse> updateBrandName(Long brandNameId, BrandNameRequest request) {
		return ObjectResponse.success(brandNameService.updateBrandName(brandNameId, request));
	}

	@Override
	public SuccessWrapper deleteBrandName(Long brandNameId) {
		return new SuccessWrapper(brandNameService.deleteBrandName(brandNameId));
	}

	@Override
	public SuccessWrapper deleteAllBrandNames() {
		return new SuccessWrapper(brandNameService.deleteAllBrandNames());
	}

	@Override
	public ObjectResponse<CompanyResponse> addCompany(CompanyRequest request) {
		return ObjectResponse.success(companyService.addCompany(request));
	}

	@Override
	public ObjectResponse<CompanyResponse> getCompany(Long companyId) {
		return ObjectResponse.success(companyService.getCompany(companyId));
	}

	@Override
	public ListResponse<CompanyResponse> getAllCompanies() {
		return ListResponse.success(companyService.getAllCompanies());
	}

	@Override
	public ObjectResponse<CompanyResponse> updateCompany(Long companyId, CompanyRequest request) {
		return ObjectResponse.success(companyService.updateCompany(companyId, request));
	}

	@Override
	public SuccessWrapper deleteCompany(Long companyId) {
		return new SuccessWrapper(companyService.deleteCompany(companyId));
	}

	@Override
	public ObjectResponse<CompanyTypeResponse> addCompanyType(CompanyTypeRequest request) {
		return ObjectResponse.success(companyService.addCompanyType(request));
	}

	@Override
	public ObjectResponse<CompanyTypeResponse> getCompanyType(Long typeId) {
		return ObjectResponse.success(companyService.getCompanyType(typeId));
	}

	@Override
	public ListResponse<CompanyTypeResponse> getAllCompanyTypes() {
		return ListResponse.success(companyService.getAllCompanyTypes());
	}

	@Override
	public ObjectResponse<CompanyTypeResponse> updateCompanyType(Long typeId, CompanyTypeRequest request) {
		return ObjectResponse.success(companyService.updateCompanyType(typeId, request));
	}

	@Override
	public SuccessWrapper deleteCompanyType(Long typeId) {
		return new SuccessWrapper(companyService.deleteCompanyType(typeId));
	}

	@Override
	public ObjectResponse<ItemResponse> addItem(ItemAddRequest request) {
		return null;
	}

	@Override
	public ListResponse<ItemResponse> addItems(ItemsAddRequest request) {
		return null;
	}

	@Override
	public ObjectResponse<ItemResponse> getItem(Long itemId) {
		return null;
	}

	@Override
	public ListResponse<ItemResponse> getAllItemsByCompany(Long companyId) {
		return null;
	}

	@Override
	public ObjectResponse<ItemResponse> updateItem(Long itemId, ItemUpdateRequest request) {
		return null;
	}

	@Override
	public SuccessWrapper deleteItem(Long itemId) {
		return new SuccessWrapper(true);
	}

	@Override
	public SuccessWrapper deleteAllItemsByCompany(Long companyId) {
		return new SuccessWrapper(true);
	}

	@Override
	public ObjectResponse<ItemTypeResponse> addItemType(ItemTypeAddRequest request) {
		return null;
	}

	@Override
	public ObjectResponse<ItemTypeResponse> getItemType(Long typeId) {
		return null;
	}

	@Override
	public ListResponse<ItemTypeResponse> getAllItemTypes() {
		return null;
	}

	@Override
	public ObjectResponse<ItemTypeResponse> updateItemType(Long typeId, ItemTypeUpdateRequest request) {
		return null;
	}

	@Override
	public SuccessWrapper deleteItemType(Long typeId) {
		return new SuccessWrapper(true);
	}

	@Override
	public ObjectResponse<CurrencyResponse> addCurrency(CurrencyAddRequest request) {
		return null;
	}

	@Override
	public ObjectResponse<CurrencyResponse> getCurrency(Long currencyId) {
		return null;
	}

	@Override
	public ListResponse<CurrencyResponse> getAllCurrencies() {
		return null;
	}

	@Override
	public ObjectResponse<CurrencyResponse> updateCurrency(Long currencyId, CurrencyUpdateRequest request) {
		return null;
	}

	@Override
	public SuccessWrapper deleteCurrency(Long currencyId) {
		return new SuccessWrapper(true);
	}

	@Override
	public ObjectResponse<ModifiedStringResponse> addModifiedString(ModifiedStringRequest request) {
		return ObjectResponse.success(modifiedStringService.addModifiedString(request));
	}

	@Override
	public ListResponse<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request) {
		return ListResponse.success(modifiedStringService.addModifiedStrings(request));
	}

	@Override
	public ObjectResponse<ModifiedStringResponse> getModifiedString(Long modifiedStringId) {
		return ObjectResponse.success(modifiedStringService.getModifiedString(modifiedStringId));
	}

	@Override
	public ListResponse<ModifiedStringResponse> getAllModifiedStrings() {
		return ListResponse.success(modifiedStringService.getAllModifiedStrings());
	}

	@Override
	public ObjectResponse<ModifiedStringResponse> updateModifiedString(Long modifiedStringId, ModifiedStringRequest request) {
		return ObjectResponse.success(modifiedStringService.updateModifiedString(modifiedStringId, request));
	}

	@Override
	public SuccessWrapper deleteModifiedString(Long modifiedStringId) {
		return new SuccessWrapper(modifiedStringService.deleteModifiedString(modifiedStringId));
	}

	@Override
	public SuccessWrapper deleteAllModifiedStrings() {
		return new SuccessWrapper(modifiedStringService.deleteAllModifiedStrings());
	}

	@Override
	public ObjectResponse<ReferenceResponse> addReference(ReferenceRequest request) {
		return ObjectResponse.success(referenceService.addReference(request));
	}

	@Override
	public ObjectResponse<ReferenceResponse> getReference(Long referenceId) {
		return ObjectResponse.success(referenceService.getReference(referenceId));
	}

	@Override
	public ListResponse<ReferenceResponse> getAllReferences() {
		return ListResponse.success(referenceService.getAllReferences());
	}

	@Override
	public ObjectResponse<ReferenceResponse> updateReference(Long referenceId, ReferenceRequest request) {
		return ObjectResponse.success(referenceService.updateReference(referenceId, request));
	}

	@Override
	public SuccessWrapper deleteReference(Long referenceId) {
		return new SuccessWrapper(referenceService.deleteReference(referenceId));
	}

	@Override
	public ObjectResponse<ReferenceTypeResponse> addReferenceType(ReferenceTypeRequest request) {
		return ObjectResponse.success(referenceService.addReferenceType(request));
	}

	@Override
	public ObjectResponse<ReferenceTypeResponse> getReferenceType(Long typeId) {
		return ObjectResponse.success(referenceService.getReferenceType(typeId));
	}

	@Override
	public ListResponse<ReferenceTypeResponse> getAllReferenceTypes() {
		return ListResponse.success(referenceService.getAllReferenceTypes());
	}

	@Override
	public ObjectResponse<ReferenceTypeResponse> updateReferenceType(Long typeId, ReferenceTypeRequest request) {
		return ObjectResponse.success(referenceService.updateReferenceType(typeId, request));
	}

	@Override
	public SuccessWrapper deleteReferenceType(Long typeId) {
		return new SuccessWrapper(referenceService.deleteReferenceType(typeId));
	}

	@Override
	public ObjectResponse<ReferenceFieldResponse> addReferenceField(ReferenceFieldRequest request) {
		return ObjectResponse.success(referenceService.addReferenceField(request));
	}

	@Override
	public ListResponse<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request) {
		return ListResponse.success(referenceService.addReferenceFields(request));
	}

	@Override
	public ObjectResponse<ReferenceFieldResponse> getReferenceField(Long fieldId) {
		return ObjectResponse.success(referenceService.getReferenceField(fieldId));
	}

	@Override
	public ListResponse<ReferenceFieldResponse> getAllReferenceFields() {
		return ListResponse.success(referenceService.getAllReferenceFields());
	}

	@Override
	public ObjectResponse<ReferenceFieldResponse> updateReferenceField(Long fieldId, ReferenceFieldRequest request) {
		return ObjectResponse.success(referenceService.updateReferenceField(fieldId, request));
	}

	@Override
	public ListResponse<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request) {
		return ListResponse.success(referenceService.updateReferenceFields(request));
	}

	@Override
	public SuccessWrapper deleteReferenceField(Long fieldId) {
		return new SuccessWrapper(referenceService.deleteReferenceField(fieldId));
	}

	@Override
	public SuccessWrapper deleteAllReferenceFieldsByReferenceId(Long referenceId) {
		return new SuccessWrapper(referenceService.deleteAllReferenceFieldsByReferenceId(referenceId));
	}

	@Override
	public ObjectResponse<UserResponse> addUser(UserRequest request) {
		return ObjectResponse.success(userService.addUser(request));
	}

	@Override
	public ObjectResponse<UserResponse> getUser(Long userId) {
		return ObjectResponse.success(userService.getUser(userId));
	}

	@Override
	public ListResponse<UserResponse> getAllUsers() {
		return ListResponse.success(userService.getAllUsers());
	}

	@Override
	public ObjectResponse<UserResponse> updateUser(Long userId, UserRequest request) {
		return ObjectResponse.success(userService.updateUser(userId, request));
	}

	@Override
	public SuccessWrapper deleteUser(Long userId) {
		return new SuccessWrapper(userService.deleteUser(userId));
	}
}
