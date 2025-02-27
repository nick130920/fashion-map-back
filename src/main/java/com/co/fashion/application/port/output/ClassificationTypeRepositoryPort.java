package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.ClassificationType;

import java.util.List;
import java.util.Optional;

public interface ClassificationTypeRepositoryPort {
	ClassificationType save(ClassificationType classification);

	List<ClassificationType> saveAll(List<ClassificationType> classifications);

	Optional<ClassificationType> findById(Long id);
	Optional<ClassificationType> findByName(String name);

	List<ClassificationType> findAll();
	List<ClassificationType> findAllWithClassifications();

	void deleteById(ClassificationType classification);
}
