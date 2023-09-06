package com.hunganh.cellphones_restcontroller.entity.customer.identity;

import com.hunganh.cellphones_restcontroller.entity.customer.CreditCard;
import com.hunganh.cellphones_restcontroller.entity.customer.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreditCardId implements Serializable {
   private CustomerAccount customerAccount;
   private CreditCard creditCard;
}
