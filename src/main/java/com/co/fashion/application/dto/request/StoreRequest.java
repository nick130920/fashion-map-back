package com.co.fashion.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class StoreRequest {
	private String name;
	private String location;
	private List<MultipartFile> images;
}
