package com.hunganh.cellphones_restcontroller.dto.request.product;

import com.hunganh.cellphones_restcontroller.common.ProductImageType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductPhotoDTO {
    private short productId;
    private String alt;
    private String url;
    private ProductImageType type;
}
