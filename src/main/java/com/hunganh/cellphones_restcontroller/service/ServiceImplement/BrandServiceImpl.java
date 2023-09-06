package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.dto.request.product.BrandDTO;
import com.hunganh.cellphones_restcontroller.entity.product.Brand;
import com.hunganh.cellphones_restcontroller.repository.product.BrandRepository;
import com.hunganh.cellphones_restcontroller.dto.response.product.BrandInfo;
import com.hunganh.cellphones_restcontroller.service.product.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<BrandInfo> getAll() {
        List<BrandInfo> dbBrands = brandRepository.findAllBy();
        return dbBrands;
    }

    @Override
    public BrandInfo save(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        return this.getInfo(brandRepository.save(brand));
    }

    @Override
    public BrandInfo getById(Short id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Brand with Id %d not found", id))
        );
        return this.getInfo(brand);
    }

    @Override
    public BrandInfo update(BrandDTO dto) {
        Brand brand = brandRepository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Brand with Id %d not found", dto.getId()))
        );
        brand.setName(dto.getName());
        return this.getInfo(brandRepository.save(brand));
    }

    private BrandInfo getInfo(Brand brand) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        BrandInfo info = pf.createProjection(BrandInfo.class, brand);
        return info;
    }
}
