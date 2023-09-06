package com.hunganh.cellphones_restcontroller.dto.response.customer;

import com.hunganh.cellphones_restcontroller.entity.customer.CustomerAddress;

/**
 * Projection for {@link CustomerAddress}
 */
public interface DefaultAddress {
    long getId();

    String getAddress();
}