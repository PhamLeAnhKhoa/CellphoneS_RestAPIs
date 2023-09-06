package com.hunganh.cellphones_restcontroller.dto.response.sales;

import com.hunganh.cellphones_restcontroller.entity.sales.Voucher;

/**
 * Projection for {@link Voucher}
 */
public interface VoucherInfo {
    Short getId();

    String getName();
}