package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.Brand;
import com.hunganh.cellphones_restcontroller.dto.response.product.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Short> {

    public List<BrandInfo> findAllBy();
}