package com.hunganh.cellphones_restcontroller.dto.request.product;

import com.hunganh.cellphones_restcontroller.common.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CProductDTO {
    private String name;
    private short brandId;
    private ProductType type;
    private double unitPrice;
    private double standardCost;
    private short categoryId;
    private short subcategoryId;
    private int discount;
}
