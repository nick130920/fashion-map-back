package com.co.fashion.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandRequest {
	private Long id;
	private String name;
	private String description;
	private String websiteUrl;
	private String instagramHandle;
	private List<StoreRequest> stores;
	private List<CreateClassificationRequest> classifications;
}
