package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.ProductPhoto;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductPhotoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Integer> {
    List<ProductPhotoInfo> findAllBy();
}