package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductCategoryDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductCategoryInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/categories")
public class CategoriesController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * PRODUCT APIs
     */
    @GetMapping(value = "products")
    public ResponseEntity<List<ProductCategoryInfo>> getAllProductCategory() {
        List<ProductCategoryInfo> db = this.productCategoryService.getAll();
        return ResponseEntity.ok(db);
    }
    @PostMapping(value = "products")
    public ResponseEntity<ProductCategoryInfo> createProductCategory(@RequestBody String name) {
        ProductCategoryInfo result = productCategoryService.save(name);
        return ResponseEntity.ok(result);
    }
    @PutMapping(value = "products")
    public ResponseEntity<ProductCategoryInfo> updateProductCategory(@RequestBody ProductCategoryDTO dto) {
        return ResponseEntity.ok(this.productCategoryService.update(dto));
    }
}
