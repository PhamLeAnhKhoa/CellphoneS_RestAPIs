package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.dto.response.customer.CustomerInfo;
import com.hunganh.cellphones_restcontroller.service.customer.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerInfo getCustomerById(long id) {
        return null;
    }
}
