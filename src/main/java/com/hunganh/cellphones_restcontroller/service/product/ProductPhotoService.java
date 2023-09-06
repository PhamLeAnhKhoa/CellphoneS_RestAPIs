package com.hunganh.cellphones_restcontroller.service.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductPhotoDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductPhotoInfo;

import java.util.List;

public interface ProductPhotoService {

    List<ProductPhotoInfo> getAll();
    ProductPhotoInfo save(ProductPhotoDTO dto);
    ProductPhotoInfo update(ProductPhotoDTO dto);
}
