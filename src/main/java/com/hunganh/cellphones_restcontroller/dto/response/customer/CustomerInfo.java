package com.hunganh.cellphones_restcontroller.dto.response.customer;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

/**
 * Projection for {@link com.hunganh.cellphones_restcontroller.entity.customer.Customer}
 */
public interface CustomerInfo {
    long getId();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    LocalDate getBirthDate();

    String getPhoneNumber();

    String getEmail();

    LocalDate getCreatedDate();

    String getDefaultAddress();
}