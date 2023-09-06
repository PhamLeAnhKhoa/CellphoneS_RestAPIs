package com.hunganh.cellphones_restcontroller.repository.customer;

import com.hunganh.cellphones_restcontroller.entity.customer.CustomerAccount;
import com.hunganh.cellphones_restcontroller.dto.response.customer.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

    CustomerLogin findById(long id);

}