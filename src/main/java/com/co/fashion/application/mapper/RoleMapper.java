package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.RoleRequest;
import com.co.fashion.application.dto.response.RoleResponse;
import com.co.fashion.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	Role toEntity(RoleRequest dto);

	RoleResponse toDto(Role entity);

	List<RoleResponse> toDtoList(List<Role> entities);

}
