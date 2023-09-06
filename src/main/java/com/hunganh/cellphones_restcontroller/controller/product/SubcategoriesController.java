package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductSubcategoryDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductSubcategoryInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/subcategories")
public class SubcategoriesController {
    @Autowired
    private ProductSubcategoryService productSubcategoryService;

    /**
     * PRODUCT APIs
     */
    @GetMapping(value = "products")
    public ResponseEntity<List<ProductSubcategoryInfo>> getAllProductSubCategory() {
        return ResponseEntity.ok(this.productSubcategoryService.getAll());
    }
    @PostMapping(value = "products")
    public ResponseEntity<ProductSubcategoryInfo> createProductSubCategory(@RequestBody ProductSubcategoryDTO dto) {
        return ResponseEntity.ok(this.productSubcategoryService.save(dto));
    }
    @PutMapping(value = "products/{subcategoryId}")
    public ResponseEntity<ProductSubcategoryInfo> updateProductSubcategory(
            @PathVariable(name = "subcategoryId") short id
            , @RequestBody String name) {
        return ResponseEntity.ok(this.productSubcategoryService.update(id, name));
    }
}
