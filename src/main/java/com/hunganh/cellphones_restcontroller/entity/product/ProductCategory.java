package com.hunganh.cellphones_restcontroller.entity.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "Product_category")
@Setter
@Getter
@NoArgsConstructor
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Short id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    private List<ProductCategorySubcategory> categorySubcategories;

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.ofInstant(this.modifiedDate, ZoneOffset.UTC);
    }

//    public List<ProductSubcategoryInfo> getSubcategories() {
//        if (this.categorySubcategories == null) {
//            return new ArrayList<>();
//        }
//        return this.categorySubcategories.stream().map(c -> {
//            ProductSubcategory subcategory = c.getSubcategory();
//            ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
//            return pf.createProjection(ProductSubcategoryInfo.class, subcategory);
//        }).collect(Collectors.toList());
//    }
}
