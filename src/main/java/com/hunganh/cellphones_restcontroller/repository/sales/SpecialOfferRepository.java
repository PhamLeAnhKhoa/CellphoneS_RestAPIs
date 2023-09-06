package com.hunganh.cellphones_restcontroller.repository.sales;

import com.hunganh.cellphones_restcontroller.dto.response.sales.CSpecialOfferInfo;
import com.hunganh.cellphones_restcontroller.entity.sales.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Short> {
    List<CSpecialOfferInfo> findAllBy();

}