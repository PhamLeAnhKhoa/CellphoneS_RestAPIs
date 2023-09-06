package com.hunganh.cellphones_restcontroller.entity.product.identity;

import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDescriptionId implements Serializable {
    private Short product;
    private Integer author;
}
