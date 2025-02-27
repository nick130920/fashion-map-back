package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.UserRequest;
import com.co.fashion.application.dto.response.UserResponse;
import com.co.fashion.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toEntity(UserRequest dto);

	UserResponse toDto(User entity);

	List<UserResponse> toDtoList(List<User> entities);

}
