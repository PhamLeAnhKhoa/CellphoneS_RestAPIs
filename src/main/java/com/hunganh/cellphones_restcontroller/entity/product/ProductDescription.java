package com.hunganh.cellphones_restcontroller.entity.product;


import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductDescriptionId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Product_description")
@Getter
@Setter
@NoArgsConstructor
@IdClass(ProductDescriptionId.class)
public class ProductDescription {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private EmployeeAccount author;

    @Column(name = "product_description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

//    public AuthorInfo getAuthorInfo() {
//        return new SpelAwareProxyProjectionFactory()
//                .createProjection(AuthorInfo.class, this.getAuthor());
//    }
//    
//    public Short getProductId() {
//        return this.product.getId();
//    }
}
