package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.ClassificationTypeRepositoryPort;
import com.co.fashion.domain.model.ClassificationType;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataClassificationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClassificationTypeRepository implements ClassificationTypeRepositoryPort {

	private final SpringDataClassificationTypeRepository springDataClassificationTypeRepository;

	@Override
	public ClassificationType save(ClassificationType classificationType) {
		return springDataClassificationTypeRepository.save(classificationType);
	}

	@Override
	public List<ClassificationType> saveAll(List<ClassificationType> classificationTypes) {
		return springDataClassificationTypeRepository.saveAll(classificationTypes);
	}

	@Override
	public Optional<ClassificationType> findById(Long id) {
		return springDataClassificationTypeRepository.findById(id);
	}

	@Override
	public Optional<ClassificationType> findByName(String name) {
		return springDataClassificationTypeRepository.findByName(name);
	}



	@Override
	public List<ClassificationType> findAll() {
		return springDataClassificationTypeRepository.findAll();
	}

	@Override
	public List<ClassificationType> findAllWithClassifications() {
		return springDataClassificationTypeRepository.findWithClassifications();
	}

	@Override
	public void deleteById(ClassificationType classificationType) {
		springDataClassificationTypeRepository.delete(classificationType);
	}
}
