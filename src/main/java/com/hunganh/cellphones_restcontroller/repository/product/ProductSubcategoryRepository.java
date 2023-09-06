package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.ProductSubcategory;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductSubcategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSubcategoryRepository extends JpaRepository<ProductSubcategory, Short> {
    List<ProductSubcategoryInfo> findAllBy();

}