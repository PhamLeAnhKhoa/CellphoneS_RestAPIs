package com.hunganh.cellphones_restcontroller.service.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.CProductDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductBox;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> getAll();
    ProductInfo save(CProductDTO dto);
    ProductInfo update(short id, CProductDTO dto);
    ProductInfo updateProductSpecification(String productId, String specification);
    List<ProductBox> getTopItemsByCategory(String categoryName, int limit);

}
