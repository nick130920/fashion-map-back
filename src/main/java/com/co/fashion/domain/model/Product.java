package com.co.fashion.domain.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;

	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand; // Relación con la marca

	@ManyToMany
	@JoinTable(
			name = "product_stores",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "store_id")
	)
	private List<Store> stores;

	@ManyToMany
	@JoinTable(
			name = "product_classification",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "classification_id")
	)
	private List<Classification> classifications;

}
