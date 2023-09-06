package com.hunganh.cellphones_restcontroller.service.sales;

import com.hunganh.cellphones_restcontroller.dto.request.sales.SpecialOfferDTO;
import com.hunganh.cellphones_restcontroller.dto.response.sales.CSpecialOfferInfo;

import java.util.List;

public interface SpecialOfferService {

    List<CSpecialOfferInfo> getAll();

    CSpecialOfferInfo save(SpecialOfferDTO dto);
}
