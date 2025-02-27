package com.co.fashion.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Image extends Auditable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String url; // URL de la imagen

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EntityType entityType;

	@Column(nullable = false)
	private Long entityId; // ID de la entidad asociada

	@PrePersist
	@PreUpdate
	private void validateEntityAssociation() {
		if (entityId == null || entityType == null) {
			throw new IllegalStateException("An image must be associated with a valid entity.");
		}
	}
}
