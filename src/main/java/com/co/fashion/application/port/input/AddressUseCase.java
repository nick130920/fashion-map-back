package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.AddressRequest;
import com.co.fashion.application.dto.response.AddressResponse;

import java.util.List;

public interface AddressUseCase {

    /**
        * Find a Address by id.
        *
        * @param id a id
        * @return a AddressResponse
    */
	AddressResponse findById(Long id);

	/**
    	 * Get a list of all Addresss.
    	 *
    	 * @return a list of AddressResponses
    */
    List<AddressResponse> findAll();

	/**
	 * Create a list of Addresss.
	 *
	 * @param requests a list of AddressRequests
	 * @return a list of AddressResponses
	 */
	List<AddressResponse> createAddresss(List<AddressRequest> requests);

	/**
	 * Create a Address.
	 *
	 * @param addressRequest a AddressRequest
	 * @return a AddressResponse
	 */
	AddressResponse createAddress(AddressRequest addressRequest);



	/**
	 * Update a Address.
	 *
	 * @param request a AddressRequest
	 * @return a AddressResponse
	 */
	AddressResponse updateAddress(AddressRequest request);

    /**
         * Delete a Address.
         *
         * @param id an id
     */
	void deleteById(Long id);





}
