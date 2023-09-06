package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.ProductDescription;
import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductDescriptionId;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductDescriptionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, ProductDescriptionId> {
    List<ProductDescriptionInfo> findAllBy();
}