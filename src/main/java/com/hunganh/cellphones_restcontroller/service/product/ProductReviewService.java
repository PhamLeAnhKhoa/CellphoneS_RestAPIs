package com.hunganh.cellphones_restcontroller.service.product;


import com.hunganh.cellphones_restcontroller.dto.request.product.ProductReviewDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductReviewInfo;

import java.util.List;

public interface ProductReviewService {

    List<ProductReviewInfo> getAll();

    ProductReviewInfo save(ProductReviewDTO dto);

    ProductReviewInfo update(ProductReviewDTO dto);
}
