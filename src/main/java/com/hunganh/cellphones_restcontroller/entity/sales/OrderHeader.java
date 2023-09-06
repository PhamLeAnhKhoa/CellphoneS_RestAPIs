package com.hunganh.cellphones_restcontroller.entity.sales;

import com.hunganh.cellphones_restcontroller.common.OrderStatus;
import com.hunganh.cellphones_restcontroller.entity.customer.CreditCard;
import com.hunganh.cellphones_restcontroller.entity.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Sales_Order_Header")
@Setter
@Getter
@NoArgsConstructor
public class OrderHeader implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_header_id")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_person_id", nullable = false)
    private SalesPerson salesPerson;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher;

    @Column(name = "order_date", nullable = false)
    @CreationTimestamp
    private Instant orderDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "online_order_flag", columnDefinition = "boolean default false")
    private boolean onlineOrderFlag;

    @Column(name = "sub_total", nullable = false)
    private BigDecimal subTotal;

    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;

    @Column(name = "voucher_discount", nullable = false)
    private BigDecimal voucherDiscount;

    @Column(name = "total_due", nullable = false)
    private BigDecimal totalDue;

    @Column(length = 2000)
    private String comment;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
