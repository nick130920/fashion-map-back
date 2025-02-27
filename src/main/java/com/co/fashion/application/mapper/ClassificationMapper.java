package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.ClassificationRequest;
import com.co.fashion.application.dto.response.ClassificationResponse;
import com.co.fashion.domain.model.Classification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassificationMapper {

	ClassificationMapper INSTANCE = Mappers.getMapper(ClassificationMapper.class);

	@Mapping(target = "id", ignore = true)
	Classification toEntity(ClassificationRequest dto);

	ClassificationResponse toDto(Classification entity);

	List<ClassificationResponse> toDtoList(List<Classification> entities);

	List<Classification> toEntityList(List<ClassificationRequest> entities);

}
