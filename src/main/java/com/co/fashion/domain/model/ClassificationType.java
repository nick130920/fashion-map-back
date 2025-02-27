package com.co.fashion.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@NamedEntityGraph(name = "ClassificationType.withClassifications",
		attributeNodes = @NamedAttributeNode("classifications"))
public class ClassificationType extends Auditable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String displayName;

	private String icon;

	@OneToMany(mappedBy = "classificationType", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Classification> classifications = new ArrayList<>();
}
