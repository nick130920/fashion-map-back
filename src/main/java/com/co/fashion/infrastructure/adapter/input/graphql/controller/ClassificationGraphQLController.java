package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.ClassificationFilterRequest;
import com.co.fashion.application.dto.request.ClassificationTypeRequest;
import com.co.fashion.application.dto.request.CreateClassificationRequest;
import com.co.fashion.application.dto.response.ClassificationResponse;
import com.co.fashion.application.dto.response.ClassificationTypeResponse;
import com.co.fashion.application.port.input.ClassificationTypeUseCase;
import com.co.fashion.application.port.input.ClassificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClassificationGraphQLController {

	private final ClassificationUseCase classificationUseCase;
	private final ClassificationTypeUseCase classificationTypeUseCase;

	@MutationMapping
	public List<ClassificationResponse> createClassifications(@Argument List<CreateClassificationRequest> classificationRequests) {
		return classificationUseCase.createClassifications(classificationRequests);
	}

	@MutationMapping
	public List<ClassificationResponse> updateClassifications(@Argument List<CreateClassificationRequest> classificationRequests) {
		return classificationUseCase.updateClassifications(classificationRequests);
	}

	@MutationMapping
	public List<ClassificationTypeResponse> createClassificationTypes(@Argument List<ClassificationTypeRequest> classificationTypeRequests) {
		return classificationTypeUseCase.createClassificationTypes(classificationTypeRequests);
	}

	@QueryMapping
	public List<ClassificationTypeResponse> getClassificationTypes() {
        return classificationTypeUseCase.getAllClassificationTypes();
    }

	@QueryMapping
    public List<ClassificationResponse> getClassifications(@Argument ClassificationFilterRequest classificationFilterRequest) {
        return classificationUseCase.getClassifications(classificationFilterRequest);
    }

	@QueryMapping
    public List<ClassificationResponse> getAllClassifications() {
        return classificationUseCase.getAllClassifications();
    }
}
