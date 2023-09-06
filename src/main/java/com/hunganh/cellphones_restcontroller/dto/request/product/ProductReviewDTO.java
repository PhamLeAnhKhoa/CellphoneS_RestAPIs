package com.hunganh.cellphones_restcontroller.dto.request.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductReviewDTO {
    private int id;
    private Short productId;
    private String reviewerName;
    private String comments;
    private short rating;
}
