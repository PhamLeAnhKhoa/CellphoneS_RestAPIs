package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.BrandDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.BrandInfo;
import com.hunganh.cellphones_restcontroller.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/brands")
public class BrandsController {

    @Autowired
    private BrandService brandService;

    /**
     * PRODUCT BRAND APIs
     */
    @GetMapping(value = "")
    public ResponseEntity<List<BrandInfo>> getBrands() {
        return ResponseEntity.ok(brandService.getAll());
    }
    @PostMapping(value = "")
    public ResponseEntity<BrandInfo> createBrand(@RequestBody String name) {
        return ResponseEntity.ok(this.brandService.save(name));
    }
    @PutMapping(value = "")
    public ResponseEntity<BrandInfo> updateBrand(@RequestBody BrandDTO dto) {
        return ResponseEntity.ok(this.brandService.update(dto));
    }
}
