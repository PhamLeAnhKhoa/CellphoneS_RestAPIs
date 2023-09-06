package com.hunganh.cellphones_restcontroller.entity.sales.identity;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.sales.OrderHeader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {
    private OrderHeader orderHeader;
    private Product product;
}
