package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.ProductCategory;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductCategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Short> {
    List<ProductCategoryInfo> findAllProductCategoryBy();

    ProductCategory findByName(String name);
}
