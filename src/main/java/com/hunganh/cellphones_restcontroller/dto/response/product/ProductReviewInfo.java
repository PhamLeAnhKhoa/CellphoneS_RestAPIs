package com.hunganh.cellphones_restcontroller.dto.response.product;

/**
 * Projection for {@link com.hunganh.cellphones_restcontroller.entity.product.ProductReview}
 */
public interface ProductReviewInfo {
    String getReviewerName();

    short getRating();

    String getComments();
}