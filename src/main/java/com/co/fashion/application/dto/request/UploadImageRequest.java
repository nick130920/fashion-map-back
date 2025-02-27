package com.co.fashion.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class UploadImageRequest {
	@NotNull("Image file cannot be null.")
	private MultipartFile file;

	@NotNull("Entity ID is required.")
	private Long entityId;

	@NotBlank(message = "Entity type is required.")
	private String entityType; // "BRAND", "STORE", "USER", "PRODUCT", "REVIEW"
}
