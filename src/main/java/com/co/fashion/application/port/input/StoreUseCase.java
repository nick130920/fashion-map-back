package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.domain.model.Image;

import java.util.List;

public interface StoreUseCase {
	/**
	 * Create a list of Stores.
	 *
	 * @param requests a list of StoreRequests
	 * @return a list of StoreResponses
	 */
	List<StoreResponse> createStores(List<StoreRequest> requests);

	/**
	 * Create a Store.
	 *
	 * @param storeInput a StoreRequest
	 * @return a StoreResponse
	 */
	StoreResponse createStore(StoreRequest storeInput);

	/**
	 * Get a list of all Stores.
	 *
	 * @return a list of StoreResponses
	 */
	List<StoreResponse> findAll();

	/**
	 * Update a Store.
	 *
	 * @param request a StoreRequest
	 * @return a StoreResponse
	 */
	StoreResponse updateStore(StoreRequest request);

	void deleteStore(Long id);

	StoreResponse findByID(Long id);

	List<StoreResponse> getStoresByBrand(Long brandId);


	List<Image> getStoreImages(Long storeId);
}
