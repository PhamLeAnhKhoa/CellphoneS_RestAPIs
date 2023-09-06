package com.hunganh.cellphones_restcontroller.entity.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Entity
@Table(name = "Brand")
@Setter
@Getter
@NoArgsConstructor
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Short id;

    @Column(name = "brand_name", nullable = false)
    private String name;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.ofInstant(this.modifiedDate, ZoneOffset.UTC);
    }
}
