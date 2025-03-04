package com.co.fashion.application.dto.request;


import com.co.fashion.domain.model.ClassificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClassificationRequest {

	private Long id;
	private String name;
	private String icon;
	private ClassificationType classificationType;

}
