package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductDescriptionDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductDescriptionInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "descriptions")
public class DescriptionsController {

    @Autowired
    private ProductDescriptionService descriptionService;

    /**
     * PRODUCT DESCRIPTION APIs
     */
    @GetMapping(value = "")
    public ResponseEntity<List<ProductDescriptionInfo>> getAllDescription() {
        return ResponseEntity.ok(descriptionService.getAll());
    }
    @PostMapping(value = "")
    public ResponseEntity<ProductDescriptionInfo> createDescription(@RequestBody ProductDescriptionDTO dto) {
        return ResponseEntity.ok(descriptionService.save(dto));
    }
    @PutMapping(value = "")
    public ResponseEntity<ProductDescriptionInfo> updateDescription(@RequestBody ProductDescriptionDTO dto) {
        return ResponseEntity.ok(descriptionService.update(dto));
    }
}
