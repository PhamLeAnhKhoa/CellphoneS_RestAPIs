package com.hunganh.cellphones_restcontroller.entity.product.identity;

import com.hunganh.cellphones_restcontroller.entity.product.ProductCategory;
import com.hunganh.cellphones_restcontroller.entity.product.ProductSubcategory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ProductCategorySubcategoryId implements Serializable {

    private Short category;

    private Short subcategory;
}
