package com.hunganh.cellphones_restcontroller.entity.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Vendor")
@Setter
@Getter
@NoArgsConstructor
public class Vendor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Short id;

    @Column(name = "vendor_name", nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String type;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
