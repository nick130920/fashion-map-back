package com.co.fashion.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BrandResponse {
	private Long id;
	private String name;
	private String description;
	private String websiteUrl;
	private String instagramHandle;
	private List<ClassificationResponse> classifications;
	private List<StoreResponse> stores;
}
