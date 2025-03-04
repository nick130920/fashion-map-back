package com.co.fashion.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Review extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brand_id", updatable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "store_id", updatable = false)
    private Store store;


    @PrePersist
    @PreUpdate
    private void validateEntityAssociation() {
        int count = (brand != null ? 1 : 0) + (product != null ? 1 : 0) + (store != null ? 1 : 0);
        if (count != 1) {
            throw new IllegalStateException("A review must be associated with exactly one entity (Brand, Product, or Store).");
        }
    }
}
