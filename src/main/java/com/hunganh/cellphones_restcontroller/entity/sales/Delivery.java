package com.hunganh.cellphones_restcontroller.entity.sales;

import com.hunganh.cellphones_restcontroller.common.DeliveryStatus;
import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Delivery")
@Setter
@Getter
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_header_id", nullable = false)
    private OrderHeader order;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id", nullable = false)
    private EmployeeAccount shipper;

    @Column(name = "ship_date")
    private LocalDate shipDate;

    @Column(name = "recipient_address", nullable = false)
    private String recipientAddress;

    @Column(name = "recipient_phone_number", length = 15, nullable = false)
    private String recipientPhoneNumber;

    @Column(name = "delivery_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column
    private String comments;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
