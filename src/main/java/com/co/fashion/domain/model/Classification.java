package com.co.fashion.domain.model;

import jakarta.persistence.*;
import jakarta.validation.ConstraintViolationException;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Classification extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;


	private String icon;

	@ManyToOne(optional = false)
	@JoinColumn(name = "classification_type_id", nullable = false)
	private ClassificationType classificationType;

	@PrePersist
	@PreUpdate
	private void validateClassificationType() {
		if (classificationType == null || classificationType.getId() == null) {
			throw new ConstraintViolationException("ClassificationTypeEntity must be valid and have an ID", null);
		}
	}

}
