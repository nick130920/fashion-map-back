package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Classification;
import com.co.fashion.domain.model.ClassificationType;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ClassificationRepositoryPort {
	Classification save(Classification classification);

	List<Classification> saveAll(List<Classification> classifications);

	Optional<Classification> findById(Long id);

	List<Classification> findWithFilters(String name, List<ClassificationType> types, PageRequest pageRequest);

	List<Classification> findAll();

	void deleteById(Classification classification);

	boolean existsByNameAndType(String name, ClassificationType type);
}
