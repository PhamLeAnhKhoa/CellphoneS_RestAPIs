package com.hunganh.cellphones_restcontroller.entity.sales.identity;

import com.hunganh.cellphones_restcontroller.entity.sales.SalesPerson;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SalesPersonQuotaHistoryId implements Serializable {
    private SalesPerson salesPerson;
    private LocalDate quotaDate;
}
