package com.co.fashion.application.dto.request;

import com.co.fashion.domain.model.ClassificationType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassificationFilterRequest {
	private String name;
	private List<ClassificationType> types;
	private String orderBy = "id"; // Ordenar por defecto por ID
	private int page = 0;  // Página 0 por defecto
	private int size = 10; // Tamaño de página por defecto

}
