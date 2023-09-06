package com.hunganh.cellphones_restcontroller.entity.product;

import com.hunganh.cellphones_restcontroller.common.ProductDetailStatus;
import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductDetailId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Product_detail")
@Setter
@Getter
@NoArgsConstructor
@IdClass(ProductDetailId.class)
public class ProductDetail {

    @Id
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @Column(name = "product_imei", length = 18, nullable = false)
    private String imei;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductDetailStatus productDetailStatus;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
