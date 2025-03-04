package com.co.fashion.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Store extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	private Double latitude;
	private Double longitude;

	@Enumerated(EnumType.STRING)
	private StoreType type;

	@Transient
	private List<Image> images;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
}
