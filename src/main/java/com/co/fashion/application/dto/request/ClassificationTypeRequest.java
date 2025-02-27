package com.co.fashion.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassificationTypeRequest {

	@NotBlank(message = "Name cannot be empty")
	private String name;

	@NotBlank(message = "Display name cannot be empty")
	private String displayName;

	private String icon;

}
