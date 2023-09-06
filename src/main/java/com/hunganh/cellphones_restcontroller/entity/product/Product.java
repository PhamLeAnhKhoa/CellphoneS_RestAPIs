package com.hunganh.cellphones_restcontroller.entity.product;

import com.hunganh.cellphones_restcontroller.common.ProductImageType;
import com.hunganh.cellphones_restcontroller.common.ProductType;
import com.hunganh.cellphones_restcontroller.dto.response.product.*;
import com.hunganh.cellphones_restcontroller.entity.sales.Voucher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "Product")
@Setter
@Getter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Short id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_subcategory_id")
    private ProductSubcategory subcategory;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_color")
    private String color;

    @Column(name = "product_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column(name = "safety_stock_level")
    private int safetyStockLevel;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "standard_cost", nullable = false)
    private Double standardCost;

    @Column(name = "reorder_point")
    private int reorderPoint;

    @Column(name = "product_specification", columnDefinition = "TEXT")
    private String productSpecification; // JSON object

    @Column(name = "sell_start_date")
    private LocalDate sellStartDate;

    @Column(name = "sell_end_date")
    private LocalDate sellEndDate;

    @Column(name = "view")
    private long view;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    @Column
    private int discount;

    /**
     * Product entity with the E-commercial website
     * ---
     * When we access the Home page of an E-commercial website, we expect to know the common information of products, such as product name, price, thumbnail image, special offers (discount percentage number, free shipping), and the average rating starts.
     * When we choose a specific product, we expect to know: the product name, price options, images, description, specification, hot product in the same category, some accessories, and product review.
     * My Resolution for the product entity
     * 1. When the Home page is requested, each entity returns its attributes and a list of special offers it's assigned for. The product service catches and creates a two-dimensional array to store the product array according to each category.
     * 2. When a user chooses a product, the entity returns its attributes, description, specification, comments, a list of related products, and a list of related accessories.
     */
//    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @JoinColumn(name = "special_offer_id")
//    private SpecialOffer discount;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<ProductPhoto> productPhotos;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    private List<ProductDescription> productDescriptions;
//
//    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    private List<ProductDetail> productDetails;
//
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<ProductReview> productReviews;

    public short getCategoryId() {
        return this.category.getId();
    }

    public short getSubcategoryId() {
        return this.subcategory.getId();
    }

    public Short getBrandId() {
        return this.brand.getId();
    }

    public String getProductSpecification() {
        return Objects.requireNonNullElse(this.productSpecification, "empty");
    };

    public BrandInfo getBrandInfo() {
        return new SpelAwareProxyProjectionFactory().createProjection(BrandInfo.class, this.getBrand());
    }

    public ProductCategoryInfo getCategoryInfo() {
        return new SpelAwareProxyProjectionFactory().createProjection(ProductCategoryInfo.class, this.getCategory());
    }

    public ProductSubcategoryInfo getSubcategoryInfo() {
        return new SpelAwareProxyProjectionFactory().createProjection(ProductSubcategoryInfo.class, this.getSubcategory());
    }

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.ofInstant(this.modifiedDate, ZoneOffset.UTC);
    }

//    public int getDiscountPercentage() {
//        if (this.discount == null) {
//            return 0;
//        }
//        return this.getDiscount().getDiscountPercentage();
//    }

    public String getFirstVoucher() {
        if(this.voucher == null) {
            return "";
        }
        System.out.println(this.voucher.getName());
        return this.voucher.getName();
    }

    public ProductPhotoInfo getPhoto() {
        return new SpelAwareProxyProjectionFactory()
                .createProjection(ProductPhotoInfo.class, this.getPhoto());
    }

    public long getAvgRating() {
        if (this.productReviews.isEmpty()) {
            return 0;
        }
        long count = this.productReviews.stream().count();
        long totalRating = this.productReviews.stream()
                .mapToLong(ProductReview::getRating)
                .sum();
        return totalRating/count;
    }

    public List<ProductReviewInfo> getProductReviewInfo() {
        if (this.productReviews.isEmpty()) {
            return new ArrayList<>();
        }
        return this.getProductReviews().stream()
                .map(c -> new SpelAwareProxyProjectionFactory()
                        .createProjection(ProductReviewInfo.class, c))
                .collect(Collectors.toList());
    }

    public ProductPhotoInfo getThumbnail() {
        List<ProductPhoto> thumbnails = this.getProductPhotos()
                .stream()
                .filter(f -> ProductImageType.THUMBNAIL.equals(f.getType()))
//                .map(productPhoto -> productPhoto)
                .collect(Collectors.toList());
        ProductPhotoInfo info = new SpelAwareProxyProjectionFactory()
                .createProjection(ProductPhotoInfo.class, thumbnails.get(0));
        return info;
    }

}
