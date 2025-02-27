package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.ClassificationTypeRequest;
import com.co.fashion.application.dto.response.ClassificationTypeResponse;
import com.co.fashion.domain.model.ClassificationType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassificationTypeMapper {

	ClassificationTypeMapper INSTANCE = Mappers.getMapper(ClassificationTypeMapper.class);

	@Mapping(target = "id", ignore = true)
	ClassificationType toEntity(ClassificationTypeRequest dto);

	ClassificationTypeResponse toDto(ClassificationType entity);

	List<ClassificationTypeResponse> toDtoList(List<ClassificationType> entities);

	List<ClassificationType> toEntityList(List<ClassificationTypeRequest> entities);

}
