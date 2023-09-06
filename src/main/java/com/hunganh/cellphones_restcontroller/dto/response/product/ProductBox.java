package com.hunganh.cellphones_restcontroller.dto.response.product;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import org.springframework.beans.factory.annotation.Value;


/**
 * Projection for {@link Product}
 */
public interface ProductBox {
    Short getId();
    String getName();
    Double getUnitPrice();
    Double getStandardCost();
    @Value("#{target.getThumbnail()}")
    ProductPhotoInfo getThumbnail();
    int getDiscount();
    @Value("#{target.getFirstVoucher()}")
    String getVoucher();
    @Value("#{target.getAvgRating()}")
    long getAvgRating();
}
