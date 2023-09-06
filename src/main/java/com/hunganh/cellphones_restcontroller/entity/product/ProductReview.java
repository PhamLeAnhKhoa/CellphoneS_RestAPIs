package com.hunganh.cellphones_restcontroller.entity.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "Product_Review")
@Getter
@Setter
@NoArgsConstructor
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_review_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "reviewer_name", nullable = false)
    private String reviewerName;

    @Column(name = "review_date", nullable = false)
    @CreationTimestamp
    private Instant reviewDate;

    @Column(name = "reviewer_email")
    private String reviewerEmail;

    @Column(nullable = false)
    private short rating;

    @Column(length = 2000)
    private String comments;

    @Column(name = "is_approved", columnDefinition = "boolean default false")
    private boolean approve;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.ofInstant(this.modifiedDate, ZoneOffset.UTC);
    }
}
