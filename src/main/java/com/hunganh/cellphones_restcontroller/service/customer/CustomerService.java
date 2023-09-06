package com.hunganh.cellphones_restcontroller.service.customer;

import com.hunganh.cellphones_restcontroller.dto.response.customer.CustomerInfo;

public interface CustomerService {

    CustomerInfo getCustomerById(long id);
}
