package com.hunganh.cellphones_restcontroller.entity.customer;

import com.hunganh.cellphones_restcontroller.common.AddressType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Customer_Addresses")
@Data
@NoArgsConstructor
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long id;

    @Column(nullable = false)
    private String address;

    @Column(name = "address_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressType type;

    @Column(length = 150, nullable = false)
    private String district;

    @Column(length = 150, nullable = false)
    private String city;

    @Column(length = 150, nullable = false)
    private String province;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
