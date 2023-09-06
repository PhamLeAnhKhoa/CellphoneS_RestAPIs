package com.hunganh.cellphones_restcontroller.service.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductSubcategoryDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductSubcategoryInfo;

import java.util.List;

public interface ProductSubcategoryService {
    List<ProductSubcategoryInfo> getAll();

    ProductSubcategoryInfo save(ProductSubcategoryDTO name);

    ProductSubcategoryInfo update(short id, String name);
}
