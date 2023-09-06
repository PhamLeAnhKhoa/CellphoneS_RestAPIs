package com.hunganh.cellphones_restcontroller.dto.request.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class BrandDTO {
    private Short id;
    private String name;
}
