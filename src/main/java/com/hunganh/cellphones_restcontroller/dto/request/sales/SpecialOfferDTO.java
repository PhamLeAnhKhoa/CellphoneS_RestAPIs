package com.hunganh.cellphones_restcontroller.dto.request.sales;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecialOfferDTO {
    private String name;
    private int discountPercentage;
    private String type;
}
