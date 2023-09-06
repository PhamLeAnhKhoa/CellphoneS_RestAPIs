package com.hunganh.cellphones_restcontroller.dto.response.product;

import com.hunganh.cellphones_restcontroller.common.ProductImageType;
import com.hunganh.cellphones_restcontroller.entity.product.ProductPhoto;

/**
 * Projection for {@link ProductPhoto}
 */
public interface ProductPhotoInfo {
    String getImgUrl();

    String getName();

    String getImgAlt();

    String getCaption();

//    ProductImageType getType();
}