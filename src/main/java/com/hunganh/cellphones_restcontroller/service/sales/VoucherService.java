package com.hunganh.cellphones_restcontroller.service.sales;

import com.hunganh.cellphones_restcontroller.dto.request.sales.CVoucherDTO;
import com.hunganh.cellphones_restcontroller.dto.response.sales.VoucherInfo;

import java.util.List;

public interface VoucherService {

    List<VoucherInfo> getAll();

    VoucherInfo save(CVoucherDTO dto);
}
