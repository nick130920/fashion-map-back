package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.ReviewRequest;
import com.co.fashion.application.dto.response.ReviewResponse;
import com.co.fashion.domain.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toEntity(ReviewRequest dto);

    ReviewResponse toDto(Review review);

    List<ReviewResponse> toDtoList(List<Review> review);
}