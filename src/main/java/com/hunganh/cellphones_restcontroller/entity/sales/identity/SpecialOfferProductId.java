package com.hunganh.cellphones_restcontroller.entity.sales.identity;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.sales.SpecialOffer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialOfferProductId implements Serializable {
    private Product product;
    private SpecialOffer specialOffer;
}
