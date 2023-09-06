package com.hunganh.cellphones_restcontroller.service.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductDescriptionDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductDescriptionInfo;

import java.util.List;

public interface ProductDescriptionService {

    List<ProductDescriptionInfo> getAll();
    ProductDescriptionInfo save(ProductDescriptionDTO dto);
    ProductDescriptionInfo update(ProductDescriptionDTO dto);
}
