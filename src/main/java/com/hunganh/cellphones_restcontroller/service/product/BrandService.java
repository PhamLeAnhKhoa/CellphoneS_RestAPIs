package com.hunganh.cellphones_restcontroller.service.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.BrandDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.BrandInfo;

import java.util.List;

public interface BrandService {
    List<BrandInfo> getAll();

    BrandInfo save(String name);

    BrandInfo getById(Short id);

    BrandInfo update(BrandDTO dto);
}
