package com.hunganh.cellphones_restcontroller.entity.utils;

import com.hunganh.cellphones_restcontroller.dto.request.product.CProductDTO;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductDescriptionDTO;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductPhotoDTO;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductReviewDTO;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductDescription;
import com.hunganh.cellphones_restcontroller.entity.product.ProductPhoto;
import com.hunganh.cellphones_restcontroller.entity.product.ProductReview;

public interface ConvertToEntity {
    Product ToEntity(CProductDTO dto);

    ProductDescription ToEntity(ProductDescriptionDTO dto);

    ProductPhoto ToEntity(ProductPhotoDTO dto);

    ProductReview ToEntity(ProductReviewDTO dto);


}
