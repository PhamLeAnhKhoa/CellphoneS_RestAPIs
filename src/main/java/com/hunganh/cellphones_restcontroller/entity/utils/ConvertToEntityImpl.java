package com.hunganh.cellphones_restcontroller.entity.utils;

import com.hunganh.cellphones_restcontroller.dto.request.product.CProductDTO;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductDescriptionDTO;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductPhotoDTO;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductReviewDTO;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductDescription;
import com.hunganh.cellphones_restcontroller.entity.product.ProductPhoto;
import com.hunganh.cellphones_restcontroller.entity.product.ProductReview;
import org.springframework.stereotype.Component;

@Component
public class ConvertToEntityImpl implements ConvertToEntity {
    @Override
    public Product ToEntity(CProductDTO dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setUnitPrice(dto.getUnitPrice());
        p.setStandardCost(dto.getStandardCost());
        p.setType(dto.getType());
        return p;
    }

    @Override
    public ProductDescription ToEntity(ProductDescriptionDTO dto) {
        ProductDescription entity = new ProductDescription();
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public ProductPhoto ToEntity(ProductPhotoDTO dto) {
        ProductPhoto entity = new ProductPhoto();
        entity.setImgAlt(dto.getAlt());
        entity.setImgUrl(dto.getUrl());
        entity.setType(dto.getType());
        return entity;
    }

    @Override
    public ProductReview ToEntity(ProductReviewDTO dto) {
        ProductReview entity = new ProductReview();
        if (dto.getId() != 0 && entity.getId() != 0) {
            entity.setId(dto.getId());
        }
        entity.setReviewerName(dto.getReviewerName());
        entity.setComments(dto.getComments());
        entity.setRating(dto.getRating());
        return entity;
    }
}
