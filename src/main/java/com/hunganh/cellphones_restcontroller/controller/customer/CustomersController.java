package com.hunganh.cellphones_restcontroller.controller.customer;

import com.hunganh.cellphones_restcontroller.dto.response.customer.CustomerInfo;
import com.hunganh.cellphones_restcontroller.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "account/user-info")
    public ResponseEntity<CustomerInfo> getCustomerById(@RequestParam long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

}
