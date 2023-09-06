package com.hunganh.cellphones_restcontroller.entity.sales;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Voucher")
@Data
@NoArgsConstructor
public class Voucher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    private Short id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

//    @Column(name = "discount_percentage", columnDefinition = "decimal(5,2)", nullable = false)
//    private double discountPercentage;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
