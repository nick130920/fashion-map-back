package com.co.fashion.application.dto.request;

import com.co.fashion.domain.model.Brand;
import com.co.fashion.domain.model.Product;
import com.co.fashion.domain.model.Store;
import com.co.fashion.domain.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private Long id;
    private String comment;
    private int rating;
    private User user;
    private Product product;
    private Brand brand;
    private Store store;
}