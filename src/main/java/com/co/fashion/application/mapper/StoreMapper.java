package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.domain.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

	StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

	@Mapping(target = "id", ignore = true)
	Store toEntity(StoreRequest dto);

	StoreResponse toDto(Store entity);

	List<StoreResponse> toDtoList(List<Store> entities);

}
