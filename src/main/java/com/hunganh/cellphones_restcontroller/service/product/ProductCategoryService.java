package com.hunganh.cellphones_restcontroller.service.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductCategoryDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductCategoryInfo;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryInfo> getAll();

    ProductCategoryInfo getById(Short id);

    ProductCategoryInfo update(ProductCategoryDTO dto);

    ProductCategoryInfo save(String name);
}
