package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.BrandRequest;
import com.co.fashion.application.dto.response.BrandResponse;
import com.co.fashion.application.port.input.BrandUseCase;
import jakarta.validation.Valid;
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
public class BrandGraphQLController {

	private final BrandUseCase brandUseCase;

	@MutationMapping
	public BrandResponse createBrand(@Valid @Argument BrandRequest brandRequest){
		return brandUseCase.createBrand(brandRequest);
	}

	@QueryMapping
	public List<BrandResponse> getAllBrands() {
		return brandUseCase.getAllBrands();
	}

	@QueryMapping
	public BrandResponse getBrandById(@Argument Long id) {
		return brandUseCase.getBrandById(id);
	}

	@MutationMapping
	public BrandResponse updateBrand(@Argument BrandRequest updateBrandRequest) {
		return brandUseCase.updateBrand(updateBrandRequest);
	}

	@MutationMapping
	public Boolean deleteBrand(@Argument Long id) {
		brandUseCase.deleteBrand(id);
		return true;
	}
}
