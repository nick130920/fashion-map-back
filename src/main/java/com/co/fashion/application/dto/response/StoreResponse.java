package com.co.fashion.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class StoreResponse {
	private Long id;
	private String name;
	private String location;
	private List<String> imageUrls;
}
