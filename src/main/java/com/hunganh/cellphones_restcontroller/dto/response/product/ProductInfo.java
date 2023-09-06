package com.hunganh.cellphones_restcontroller.dto.response.product;

import com.hunganh.cellphones_restcontroller.common.ProductType;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Product}
 */
public interface ProductInfo {
    Short getId();

    String getName();

    //    String getCode();
//
//    String getColor();
//
    ProductType getType();

    Double getUnitPrice();

    Double getStandardCost();

//    @Value("#{target.getThumbnail()}")
//    ProductPhotoInfo getThumbnail();

    @Value(("#{target.getBrandInfo()}"))
    BrandInfo getBrandInfo();

    Short getCategoryId();

    Short getSubcategoryId();

//    List<SpecialOfferInfo> getSpecialOffers();

//    String getProductSpecification();
}