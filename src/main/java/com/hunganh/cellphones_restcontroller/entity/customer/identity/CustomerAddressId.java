package com.hunganh.cellphones_restcontroller.entity.customer.identity;

import com.hunganh.cellphones_restcontroller.entity.customer.Customer;
import com.hunganh.cellphones_restcontroller.entity.customer.CustomerAccount;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerAddressId implements Serializable {
    private long customer;
    private long address;
}
