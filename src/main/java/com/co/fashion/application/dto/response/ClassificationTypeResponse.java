package com.co.fashion.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ClassificationTypeResponse {
	private Long id;
	private String name;
	private String displayName;
	private String icon;
	private List<ClassificationResponse> classifications;

}
