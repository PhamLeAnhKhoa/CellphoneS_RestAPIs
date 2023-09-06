package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductPhotoDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductPhotoInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/photos")
public class PhotosController {

    @Autowired
    private ProductPhotoService photoService;

    /**
     * PRODUCT PHOTO APIs
     */
    // value = "api/category/{categoryId}/subcategory"
    @GetMapping(value = "")
    public ResponseEntity<List<ProductPhotoInfo>> getPhotos() {
        return ResponseEntity.ok(photoService.getAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<ProductPhotoInfo> addProductPhoto(@RequestBody ProductPhotoDTO dto) {
        return ResponseEntity.ok(photoService.save(dto));
    }

    @PutMapping(value = "")
    public ResponseEntity<ProductPhotoInfo> updatePhoto(@RequestBody ProductPhotoDTO dto) {
        return ResponseEntity.ok(photoService.update(dto));
    }
}
