package com.co.fashion.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClassificationRequest {

	private Long id;
	private String name;
	private String icon;
	private Long type;

}
