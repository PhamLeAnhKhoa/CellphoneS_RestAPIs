package com.hunganh.cellphones_restcontroller.entity.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Customer_Account")
@Getter
@Setter
@NoArgsConstructor
public class CustomerAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_account_id")
    private long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", length = 150, nullable = false)
    private String passwordHash;

    @Column(name = "password_salt", length = 50, nullable = false)
    private String passwordSalt;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private Instant createdDate;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    public long getCustomerId() {
        return this.getCustomer().getId();
    }
}
