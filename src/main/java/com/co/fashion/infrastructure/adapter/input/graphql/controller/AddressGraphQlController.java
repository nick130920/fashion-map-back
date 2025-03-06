package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.AddressRequest;
import com.co.fashion.application.dto.response.AddressResponse;
import com.co.fashion.application.port.input.AddressUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AddressGraphQlController {

	private final AddressUseCase addressUseCase;


	@QueryMapping
	public AddressResponse address(@Argument Long id) {
		return addressUseCase.findById(id);
	}

	@QueryMapping
	public List<AddressResponse> addresss() {
		return addressUseCase.findAll();
	}

	@MutationMapping
	public AddressResponse createAddress(@Argument AddressRequest addressRequest) {
		return addressUseCase.createAddress(addressRequest);
	}

	@MutationMapping
	public List<AddressResponse> createAddresss(@Argument List<AddressRequest> addressRequest) {
		return addressUseCase.createAddresss(addressRequest);
	}

	@MutationMapping
	public AddressResponse updateAddress(@Argument AddressRequest addressRequest) {
		return addressUseCase.updateAddress(addressRequest);
	}

	@MutationMapping
	public Boolean deleteAddress(@Argument Long id) {
		addressUseCase.deleteById(id);
		return true;
	}

}
