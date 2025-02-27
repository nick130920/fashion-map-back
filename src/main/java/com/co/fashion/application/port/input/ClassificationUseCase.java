package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.ClassificationFilterRequest;
import com.co.fashion.application.dto.request.ClassificationRequest;
import com.co.fashion.application.dto.request.CreateClassificationRequest;
import com.co.fashion.application.dto.response.ClassificationResponse;

import java.util.List;

public interface ClassificationUseCase {
	ClassificationResponse createClassification(ClassificationRequest request);
	List<ClassificationResponse> createClassifications(List<CreateClassificationRequest> request);
	List<ClassificationResponse> updateClassifications(List<CreateClassificationRequest> request);
	List<ClassificationResponse> getClassifications(ClassificationFilterRequest classificationFilterRequest);
	List<ClassificationResponse> getAllClassifications();
}
