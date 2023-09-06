package com.hunganh.cellphones_restcontroller.entity.product.identity;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailId implements Serializable {
    private Product product;
    private String imei;
}
