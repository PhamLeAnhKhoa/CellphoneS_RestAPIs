package com.hunganh.cellphones_restcontroller.dto.request.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ProductSubcategoryDTO {
    private String name;
    private Short categoryId;
}
