package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.dto.response.product.ProductBox;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductInfo;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Short> {
    List<ProductInfo> findAllBy();

    List<ProductBox> findAllByCategoryOrderByModifiedDateDesc(ProductCategory category, Pageable pageable);

}