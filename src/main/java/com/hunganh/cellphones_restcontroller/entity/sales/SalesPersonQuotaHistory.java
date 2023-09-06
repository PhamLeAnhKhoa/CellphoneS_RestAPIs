package com.hunganh.cellphones_restcontroller.entity.sales;

import com.hunganh.cellphones_restcontroller.entity.sales.identity.SalesPersonQuotaHistoryId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Sales_Person_Quota_History")
@Setter
@Getter
@NoArgsConstructor
@IdClass(SalesPersonQuotaHistoryId.class)
public class SalesPersonQuotaHistory {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sale_person_id")
    private SalesPerson salesPerson;

    @Id
    @Column(name = "quota_date", nullable = false)
    private LocalDate quotaDate;

    @Column(name = "sales_quota", nullable = false)
    private BigDecimal salesQuota;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
