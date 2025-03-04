package com.co.fashion.infrastructure.adapter.output.specification;

import com.co.fashion.domain.model.Classification;
import com.co.fashion.domain.model.ClassificationType;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ClassificationSpecification {
	private ClassificationSpecification() {	}
	public static Specification<Classification> filterByName(String name){
		return (root, query, criteriaBuilder) -> {
			if (name != null && name.isBlank()){
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+ name.toLowerCase() + "%");
		};
	}

	public static Specification<Classification> filterByTypes(List<ClassificationType> types) {
		return (root, query, criteriaBuilder) -> {
			if (types == null || types.isEmpty()) {
				return criteriaBuilder.conjunction(); // No aplicar filtro
			}
			return root.get("type").in(types);
		};
	}
}
