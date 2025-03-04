package com.co.fashion.application.dto.request;

import com.co.fashion.domain.model.StoreType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Request DTO for creating a store.
 */
@Getter
@Setter
public class StoreRequest {
	/**
	 * The name of the store.
	 */
	private String name;
	/**
	 * The location of the store.
	 */
	private String location;
	/**
	 * The latitude of the store.
	 */
	private Double latitude;
	/**
	 * The longitude of the store.
	 */
	private Double longitude;
	/**
	 * The type of the store.
	 */
	private StoreType type;
	/**
	 * The ID of the brand.
	 */
	private Long brandId;
	/**
	 * A list of images for the store.
	 */
	private List<MultipartFile> images;
}
