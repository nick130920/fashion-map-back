package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.domain.model.Brand;
import com.co.fashion.domain.model.Image;
import com.co.fashion.domain.model.Store;

import java.util.List;

public interface StoreUseCase {
	List<Store> createStores(List<StoreRequest> requests, Brand brand);

	Store createStore(StoreRequest storeInput, Brand brand);

	List<Store> getAllStores();

	StoreResponse updateStore(StoreRequest request);

	void deleteStore(Store store);

	StoreResponse getStoreById(Long id);

	List<StoreResponse> getStoresByBrand(Long brandId);


	List<Image> getStoreImages(Long storeId);
}
