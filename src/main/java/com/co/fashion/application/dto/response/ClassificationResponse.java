package com.co.fashion.application.dto.response;

import com.co.fashion.domain.model.ClassificationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClassificationResponse {
	private Long id;
	private String name;
	private String icon;
	private ClassificationType classificationType;

}
