package com.hunganh.cellphones_restcontroller.dto.response.customer;

/**
 * Projection for {@link com.hunganh.cellphones_restcontroller.entity.customer.CustomerAccount}
 */
public interface CustomerLogin {
    long getId();

    long getCustomerId();

    String getUsername();

    String getPasswordHash();

    String getPasswordSalt();

    CustomerInfo getCustomer();
}