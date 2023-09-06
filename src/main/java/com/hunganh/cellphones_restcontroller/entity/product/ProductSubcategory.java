package com.hunganh.cellphones_restcontroller.entity.product;

import lombok.EqualsAndHashCode;
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
@Table(name = "Product_subcategory")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ProductSubcategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_subcategory_id")
    @EqualsAndHashCode.Exclude
    private Short id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.ofInstant(this.modifiedDate, ZoneOffset.UTC);
    }
}
