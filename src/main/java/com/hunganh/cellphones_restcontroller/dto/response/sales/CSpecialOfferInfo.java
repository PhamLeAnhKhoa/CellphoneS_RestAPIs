package com.hunganh.cellphones_restcontroller.dto.response.sales;

import com.hunganh.cellphones_restcontroller.entity.sales.SpecialOffer;

import java.time.LocalDateTime;

/**
 * Projection for {@link SpecialOffer}
 */
public interface CSpecialOfferInfo {
    Short getId();

    String getName();

    int getDiscountPercentage();

    String getType();

    LocalDateTime getModifiedDate();
}