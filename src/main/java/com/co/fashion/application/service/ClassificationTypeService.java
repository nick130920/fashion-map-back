package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.ClassificationTypeRequest;
import com.co.fashion.application.dto.response.ClassificationTypeResponse;
import com.co.fashion.application.mapper.ClassificationTypeMapper;
import com.co.fashion.application.port.input.ClassificationTypeUseCase;
import com.co.fashion.application.port.output.ClassificationTypeRepositoryPort;
import com.co.fashion.domain.model.ClassificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassificationTypeService implements ClassificationTypeUseCase {

	private final ClassificationTypeRepositoryPort classificationTypeRepositoryPort;
	private final ClassificationTypeMapper classificationTypeMapper;

	@Override
	@Transactional
	public ClassificationTypeResponse createClassificationType(ClassificationTypeRequest classificationTypeRequest) {
		ClassificationType classificationType = classificationTypeMapper.toEntity(classificationTypeRequest);
		if (classificationTypeRepositoryPort.findByName(classificationTypeRequest.getName()).isPresent()) {
			throw new IllegalArgumentException("ClassificationType already exists: " + classificationTypeRequest.getName());
		}

		classificationType = classificationTypeRepositoryPort.save(classificationType);

		return classificationTypeMapper.toDto(classificationType);
	}

	@Override
	@Transactional
	public List<ClassificationTypeResponse> createClassificationTypes(List<ClassificationTypeRequest> request) {
		List<ClassificationType> classificationTypes = classificationTypeMapper.toEntityList(request);
		classificationTypes = classificationTypeRepositoryPort.saveAll(classificationTypes);


		return classificationTypeMapper.toDtoList(classificationTypes);
	}

	@Override
	public List<ClassificationTypeResponse> getAllClassificationTypes() {

		List<ClassificationType> classificationTypes = classificationTypeRepositoryPort.findAllWithClassifications();
		return classificationTypeMapper.toDtoList(classificationTypes);
	}
}
