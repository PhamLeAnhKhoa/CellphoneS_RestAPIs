package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.dto.request.sales.SpecialOfferDTO;
import com.hunganh.cellphones_restcontroller.dto.response.sales.CSpecialOfferInfo;
import com.hunganh.cellphones_restcontroller.entity.sales.SpecialOffer;
import com.hunganh.cellphones_restcontroller.repository.sales.SpecialOfferRepository;
import com.hunganh.cellphones_restcontroller.service.sales.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialOfferServiceImpl implements SpecialOfferService {

    @Autowired
    private SpecialOfferRepository repository;

    @Override
    public List<CSpecialOfferInfo> getAll() {
        return repository.findAllBy();
    }

    @Override
    public CSpecialOfferInfo save(SpecialOfferDTO dto) {
        return getCSpecialOfferInfo(repository.save(convertor(dto)));
    }

    private SpecialOffer convertor(SpecialOfferDTO dto) {
        SpecialOffer offer = new SpecialOffer();
        offer.setName(dto.getName());
        offer.setDiscountPercentage(dto.getDiscountPercentage());
        offer.setType(dto.getType());
        return offer;
    }

    private CSpecialOfferInfo getCSpecialOfferInfo(SpecialOffer entity) {
        return new SpelAwareProxyProjectionFactory()
                .createProjection(CSpecialOfferInfo.class, entity);
    }
}
