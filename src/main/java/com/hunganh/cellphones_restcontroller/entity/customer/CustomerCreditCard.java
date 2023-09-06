package com.hunganh.cellphones_restcontroller.entity.customer;

import com.hunganh.cellphones_restcontroller.entity.customer.identity.CustomerCreditCardId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Customer_Credit_Card")
@Getter
@Setter
@NoArgsConstructor
@IdClass(CustomerCreditCardId.class)
public class CustomerCreditCard implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_account_id", nullable = false)
    private CustomerAccount customerAccount;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard creditCard;

    @Column(name = "is_primary", columnDefinition = "boolean default false")
    private boolean isPrimary;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
