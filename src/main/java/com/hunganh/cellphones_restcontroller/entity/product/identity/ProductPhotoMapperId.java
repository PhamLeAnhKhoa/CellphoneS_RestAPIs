package com.hunganh.cellphones_restcontroller.entity.product.identity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ProductPhotoMapperId implements Serializable {
    private short product;
    private int photo;
}
