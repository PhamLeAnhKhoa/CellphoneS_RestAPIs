package com.hunganh.cellphones_restcontroller.dto.response.product;

import com.hunganh.cellphones_restcontroller.dto.response.employee.AuthorInfo;
import com.hunganh.cellphones_restcontroller.entity.product.ProductDescription;

/**
 * Projection for {@link ProductDescription}
 */
public interface ProductDescriptionInfo {
    String getDescription();

    ProductId getProduct();

    AuthorInfo getAuthor();
}