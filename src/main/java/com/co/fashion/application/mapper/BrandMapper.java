package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.BrandRequest;
import com.co.fashion.application.dto.response.BrandResponse;
import com.co.fashion.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

	Brand toEntity(BrandRequest dto);

	BrandResponse toDto(Brand entity);

	List<BrandResponse> toDtoList(List<Brand> entities);

}
