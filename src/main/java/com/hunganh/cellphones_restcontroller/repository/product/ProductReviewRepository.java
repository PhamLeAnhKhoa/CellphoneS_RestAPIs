package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.ProductReview;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    List<ProductReviewInfo> findAllBy();
}