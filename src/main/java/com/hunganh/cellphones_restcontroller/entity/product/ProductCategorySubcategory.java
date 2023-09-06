//package com.hunganh.cellphones_restcontroller.entity.product;
//
//import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductCategorySubcategoryId;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.Instant;
//
//@Entity
//@Table(name = "Product_Category_Subcategory")
//@Data
//@NoArgsConstructor
//@IdClass(ProductCategorySubcategoryId.class)
//public class ProductCategorySubcategory implements Serializable {
//    @Id
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Product_Category_id")
//    private ProductCategory category;
//
//    @Id
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Product_Subcategory_id")
//    private ProductSubcategory subcategory;
//
//    @Column(name = "modified_date", nullable = false)
//    @UpdateTimestamp
//    private Instant modifiedDate;
//}
