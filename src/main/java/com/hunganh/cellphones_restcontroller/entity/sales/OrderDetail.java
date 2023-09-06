package com.hunganh.cellphones_restcontroller.entity.sales;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.sales.identity.OrderDetailId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "Sales_Order_Detail")
@Setter
@Getter
@NoArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "Sales_order_id", nullable = false)
    private OrderHeader orderHeader;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "special_offer_id", nullable = false)
    private SpecialOffer specialOffer;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "unit_price_discount", nullable = false)
    private BigDecimal unitPriceDiscount;

    @Column(name = "line_total", nullable = false)
    private BigDecimal lineTotal;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
