package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.application.port.output.BrandRepositoryPort;
import com.co.fashion.domain.model.Brand;
import com.co.fashion.domain.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StoreMapper {

	@Autowired
	private BrandRepositoryPort brandRepositoryPort;

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "brand", expression = "java(findBrandById(dto.getBrandId()))")
	public abstract Store toEntity(StoreRequest dto);

	public abstract StoreResponse toDto(Store entity);

	public abstract List<StoreResponse> toDtoList(List<Store> entities);

	protected Brand findBrandById(Long brandId) {
		return brandRepositoryPort.findById(brandId)
				.orElseThrow(() -> new RuntimeException("Brand not found"));
	}
}
