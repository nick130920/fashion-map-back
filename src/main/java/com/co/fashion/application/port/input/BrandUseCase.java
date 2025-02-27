package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.BrandRequest;
import com.co.fashion.application.dto.response.BrandResponse;

import java.util.List;

public interface BrandUseCase {
	BrandResponse createBrand(BrandRequest request);
	List<BrandResponse> getAllBrands();
	BrandResponse getBrandById(Long id);
	BrandResponse updateBrand(BrandRequest request);
	void deleteBrand(Long id);
}
