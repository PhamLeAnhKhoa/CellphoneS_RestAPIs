package com.hunganh.cellphones_restcontroller.entity.person;

import com.hunganh.cellphones_restcontroller.common.AddressType;
import com.hunganh.cellphones_restcontroller.entity.person.identity.AddressId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AddressId.class)
public class Address {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(nullable = false)
    private String address;

    @Column(name = "address_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Column(length = 50, nullable = false)
    private String district;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String province;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
