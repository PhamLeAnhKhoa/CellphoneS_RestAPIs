package com.hunganh.cellphones_restcontroller.dto.request.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDescriptionDTO {
    private Short productId;
    private Integer authorId;
    private String description;

}
