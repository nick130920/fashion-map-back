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
public class Brand extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;
	private String description;
	private String websiteUrl;
	private String instagramHandle;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@Builder.Default
	private List<Store> stores = new ArrayList<>();

	@OneToMany(mappedBy = "brand", cascade = CascadeType.PERSIST)
	private List<Review> reviews; // Relación con reseñas

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "brand_classification",
			joinColumns = @JoinColumn(name = "brand_id"),
			inverseJoinColumns = @JoinColumn(name = "classification_id")
	)
	private List<Classification> classifications;
}