package com.hunganh.cellphones_restcontroller.entity.sales.identity;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.sales.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreInventoryId implements Serializable {
    private Store store;
    private Product product;
}
