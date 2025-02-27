package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.response.ImageResponse;
import com.co.fashion.application.port.input.StoreUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StoreGraphQLController {

	private final StoreUseCase storeUseCase;

	@QueryMapping
	public List<ImageResponse> getStoreImages(@Argument Long storeId) {
		return storeUseCase.getStoreImages(storeId).stream()
				.map(img -> new ImageResponse(img.getId(), img.getUrl()))
				.toList();
	}
}
