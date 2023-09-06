package com.hunganh.cellphones_restcontroller.entity.product;

import com.hunganh.cellphones_restcontroller.common.ProductImageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Product_Photo")
@Getter
@Setter
@NoArgsConstructor
public class ProductPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_photo_id")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "is_primary", columnDefinition = "boolean default false")
    private boolean primary;

    @Column(name = "img_url", length = 1000, nullable = false)
    private String imgUrl;

    @Column(name = "img_name")
    private String name;

    @Column(name = "img_alt")
    private String imgAlt;

    @Column(length = 2000)
    private String caption;

    @Column(name = "img_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductImageType type;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
