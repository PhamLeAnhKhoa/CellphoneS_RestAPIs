package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.ProductDetail;
import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, ProductDetailId> {
}