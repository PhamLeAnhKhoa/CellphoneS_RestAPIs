package com.hunganh.cellphones_restcontroller.repository.sales;

import com.hunganh.cellphones_restcontroller.dto.response.sales.VoucherInfo;
import com.hunganh.cellphones_restcontroller.entity.sales.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Short> {
    List<VoucherInfo> findAllBy();
}