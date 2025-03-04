package com.co.fashion.application.dto.response;

import com.co.fashion.domain.model.StoreType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StoreResponse {
	private Long id;
	private String name;
	private String location;
	private Double latitude;
	private Double longitude;
	private StoreType type;
	private List<ImageResponse> images;
}
