package com.hunganh.cellphones_restcontroller.dto.response.product;

import com.hunganh.cellphones_restcontroller.dto.response.sales.VoucherInfo;

import java.util.List;

/**
 * Projection for {@link com.hunganh.cellphones_restcontroller.entity.product.Product}
 */
public interface ProductDetail {
    Short getId();

    String getName();

    Double getUnitPrice();

    Double getStandardCost();

    String getProductSpecification();

    int getDiscount();

    List<VoucherInfo> getVouchers();

    List<ProductPhotoInfo> getProductPhotos();
}