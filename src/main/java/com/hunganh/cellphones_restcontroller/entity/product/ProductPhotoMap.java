package com.hunganh.cellphones_restcontroller.entity.product;

import com.hunganh.cellphones_restcontroller.common.ProductImageType;
import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductPhotoMapperId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Product_Photo_Mapper")
@IdClass(ProductPhotoMapperId.class)
public class ProductPhotoMap {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_photo_id")
    private ProductPhoto photo;

    @Column(name = "img_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductImageType type;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
