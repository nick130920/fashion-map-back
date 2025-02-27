package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.ClassificationFilterRequest;
import com.co.fashion.application.dto.request.ClassificationRequest;
import com.co.fashion.application.dto.request.CreateClassificationRequest;
import com.co.fashion.application.dto.response.ClassificationResponse;
import com.co.fashion.application.mapper.ClassificationMapper;
import com.co.fashion.application.port.input.ClassificationUseCase;
import com.co.fashion.application.port.output.ClassificationRepositoryPort;
import com.co.fashion.application.port.output.ClassificationTypeRepositoryPort;
import com.co.fashion.domain.model.Classification;
import com.co.fashion.domain.model.ClassificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassificationService implements ClassificationUseCase {

	public static final String CLASSIFICATION_TYPE_NOT_FOUND = "Classification type not found: ";
	private final ClassificationRepositoryPort classificationRepositoryPort;
	private final ClassificationTypeRepositoryPort classificationTypeRepositoryPort;
	private final ClassificationMapper classificationMapper;

	@Override
	@Transactional
	public ClassificationResponse createClassification(ClassificationRequest classificationRequest) {
		ClassificationType classificationType = classificationTypeRepositoryPort.findByName(classificationRequest.getType().getName())
				.orElseThrow(() -> new RuntimeException(CLASSIFICATION_TYPE_NOT_FOUND + classificationRequest.getType()));

		Classification classification = Classification.builder()
				.name(classificationRequest.getName())
				.classificationType(classificationType)
				.build();

		Classification savedClassification = classificationRepositoryPort.save(classification);

		return ClassificationResponse.builder()
				.id(savedClassification.getId())
				.name(savedClassification.getName())
				.classificationType(savedClassification.getClassificationType())
				.build();
	}

	@Override
	@Transactional
	public List<ClassificationResponse> createClassifications(List<CreateClassificationRequest> request) {
		List<Classification> classifications = request.stream()
				.map(classification -> {
					ClassificationType classificationType = classificationTypeRepositoryPort.findById(classification.getType())
                            .orElseThrow(() -> new RuntimeException(CLASSIFICATION_TYPE_NOT_FOUND + classification.getType()));

					if (classificationRepositoryPort.existsByNameAndType(classification.getName(), classificationType)) {
						throw new KeyAlreadyExistsException("Classification already exists: " + classification.getName());
					}
                    return Classification.builder()
                            .name(classification.getName())
                            .classificationType(classificationType)
                            .build();
				}).toList();

		classifications = classificationRepositoryPort.saveAll(classifications);


		return classificationMapper.toDtoList(classifications);
	}

	@Override
	@Transactional
	public List<ClassificationResponse> updateClassifications(List<CreateClassificationRequest> request) {
		List<Classification> classifications = request.stream()
				.map(classification -> {
					ClassificationType classificationType = classificationTypeRepositoryPort.findById(classification.getType())
                            .orElseThrow(() -> new RuntimeException(CLASSIFICATION_TYPE_NOT_FOUND + classification.getType()));
                    return Classification.builder()
							.id(classification.getId())
                            .name(classification.getName())
							.icon(classification.getIcon())
                            .classificationType(classificationType)
                            .build();
				}).toList();

		classifications = classificationRepositoryPort.saveAll(classifications);


		return classificationMapper.toDtoList(classifications);
	}

	@Override
	public List<ClassificationResponse> getClassifications(ClassificationFilterRequest classificationFilterRequest) {
		// Configurar ordenamiento y paginación
		Sort sort = Sort.by(Sort.Direction.ASC, classificationFilterRequest.getOrderBy());
		PageRequest pageRequest = PageRequest.of(classificationFilterRequest.getPage(), classificationFilterRequest.getSize(), sort);

		// Obtener clasificaciones con filtro
		List<Classification> classifications = classificationRepositoryPort.findWithFilters(
				classificationFilterRequest.getName(), classificationFilterRequest.getTypes(), pageRequest);

		return classificationMapper.toDtoList(classifications);
	}

	@Override
	public List<ClassificationResponse> getAllClassifications() {
		List<Classification> classification = classificationRepositoryPort.findAll();
		log.info(classification.getFirst().getClassificationType().getIcon());
		return classificationMapper.toDtoList(classification);

	}
}
