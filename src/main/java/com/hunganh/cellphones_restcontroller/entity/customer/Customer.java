package com.hunganh.cellphones_restcontroller.entity.customer;

import com.hunganh.cellphones_restcontroller.common.AddressType;
import com.hunganh.cellphones_restcontroller.common.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type")
    private CustomerType customerType;

    @Column(name = "first_name", length = 150, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(length = 150, unique = true)
    private String email;

    @Column(name = "email_promotion", columnDefinition = "boolean default false")
    private boolean emailPromotion;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private Instant createdDate;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CustomerAddressMap> customerAddressList;

    public String getDefaultAddress() {
        List<CustomerAddress> addressList = this.getCustomerAddressList()
                .stream().map(c -> c.getAddress()).collect(Collectors.toList());
        for(CustomerAddress address : addressList) {
            if (address.getType().equals(AddressType.DEFAULT)) {
                return String.format("%s, %s, %s", address.getAddress(), address.getDistrict(), address.getCity());
            }
        }
        return "The address is not assigned";
    }

    public LocalDate getCreatedDate() {
        return LocalDate.ofInstant(this.createdDate, ZoneOffset.UTC);
    }
}
