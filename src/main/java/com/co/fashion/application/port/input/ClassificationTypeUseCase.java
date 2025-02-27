package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.ClassificationTypeRequest;
import com.co.fashion.application.dto.response.ClassificationTypeResponse;

import java.util.List;

public interface ClassificationTypeUseCase {
	ClassificationTypeResponse createClassificationType(ClassificationTypeRequest request);
	List<ClassificationTypeResponse> createClassificationTypes(List<ClassificationTypeRequest> request);
	List<ClassificationTypeResponse> getAllClassificationTypes();
}
