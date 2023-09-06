package com.hunganh.cellphones_restcontroller.entity.sales;

import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "Sales_person")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class SalesPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_person_id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_account_id", nullable = false)
    private EmployeeAccount employeeAccount;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "sales_quota")
    private BigDecimal salesQuota;

    @Column(name = "bonus")
    private BigDecimal bonus;

    @Column(name = "commission_percentage")
    private double commissionPercentage;

    @Column(name = "sales_ytd")
    private BigDecimal salesYtd;

    @Column(name = "sales_last_year")
    private BigDecimal salesLastYear;

    @Column(name = "modified_date", nullable = false)
    private Instant modifiedDate;
}
