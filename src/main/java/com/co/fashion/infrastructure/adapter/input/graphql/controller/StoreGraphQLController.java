package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.ImageResponse;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.application.port.input.StoreUseCase;
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
public class StoreGraphQLController {

	private final StoreUseCase storeUseCase;


	@QueryMapping
	public StoreResponse store(@Argument Long id) {
		return storeUseCase.findByID(id);
	}

	@QueryMapping
	public List<StoreResponse> stores() {
		return storeUseCase.findAll();
	}

	@MutationMapping
	public StoreResponse createStore(@Argument StoreRequest storeRequest) {
		return storeUseCase.createStore(storeRequest);
	}

	@MutationMapping
	public List<StoreResponse> createStores(@Argument List<StoreRequest> storeRequest) {
		return storeUseCase.createStores(storeRequest);
	}

	@MutationMapping
	public StoreResponse updateStore(@Argument StoreRequest storeRequest) {
		return storeUseCase.updateStore(storeRequest);
	}

	@MutationMapping
	public Boolean deleteStore(@Argument Long id) {
		storeUseCase.deleteStore(id);
		return true;
	}

	@QueryMapping
	public List<ImageResponse> imagesByStoreId(@Argument Long id) {
		return storeUseCase.getStoreImages(id).stream()
				.map(img -> new ImageResponse(img.getId(), img.getUrl()))
				.toList();
	}
}
