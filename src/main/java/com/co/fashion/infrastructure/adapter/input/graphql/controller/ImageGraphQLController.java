package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.response.ImageResponse;
import com.co.fashion.application.port.input.ImageUseCase;
import com.co.fashion.domain.model.EntityType;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class ImageGraphQLController {

	private final ImageUseCase imageUseCase;

	@MutationMapping
	public ImageResponse uploadImage(@Argument Long entityId, @Argument String entityType, @Argument MultipartFile file) {
		EntityType type;
		try {
			type = EntityType.valueOf(entityType.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid entityType: " + entityType);
		}
		return imageUseCase.uploadImage(entityId, type, file);
	}
}
