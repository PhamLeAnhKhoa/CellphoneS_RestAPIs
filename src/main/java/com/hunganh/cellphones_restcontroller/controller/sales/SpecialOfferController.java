package com.hunganh.cellphones_restcontroller.controller.sales;

import com.hunganh.cellphones_restcontroller.dto.request.sales.SpecialOfferDTO;
import com.hunganh.cellphones_restcontroller.dto.response.sales.CSpecialOfferInfo;
import com.hunganh.cellphones_restcontroller.service.sales.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/specialoffers")
public class SpecialOfferController {

    @Autowired
    private SpecialOfferService SPService;

    @GetMapping(value = "")
    public List<CSpecialOfferInfo> getAll() {
        return SPService.getAll();
    }

    @PostMapping(value = "")
    public CSpecialOfferInfo createSpecialOffer(SpecialOfferDTO dto) {
        return SPService.save(dto);
    }

}
