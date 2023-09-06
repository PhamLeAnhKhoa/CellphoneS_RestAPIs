package com.hunganh.cellphones_restcontroller.entity.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "Special_offer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialOffer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "special_offer_id")
    private Short id;

    @Column(nullable = false) // added May 21st, 2023
    private String name;

    @Column
    private String description;

    @Column(name = "discount_percentage", nullable = false)
    private int discountPercentage;

    @Column(length = 50)
    private String type;

    @Column(length = 50)
    private String category;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "min_quantity")
    private int minQuantity;

    @Column(name = "max_quantity")
    private int maxQuantity;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.ofInstant(this.modifiedDate, ZoneOffset.UTC);
    }
}
