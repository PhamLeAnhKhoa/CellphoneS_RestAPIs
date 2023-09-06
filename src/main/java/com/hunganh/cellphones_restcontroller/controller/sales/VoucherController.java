package com.hunganh.cellphones_restcontroller.controller.sales;

import com.hunganh.cellphones_restcontroller.dto.request.sales.CVoucherDTO;
import com.hunganh.cellphones_restcontroller.dto.response.sales.VoucherInfo;
import com.hunganh.cellphones_restcontroller.service.sales.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService vService;

    @GetMapping(value = "")
    public ResponseEntity<List<VoucherInfo>> getAll() {
        return ResponseEntity.ok(vService.getAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<VoucherInfo> createVoucher(CVoucherDTO dto) {
        return ResponseEntity.ok(vService.save(dto));
    }
}
