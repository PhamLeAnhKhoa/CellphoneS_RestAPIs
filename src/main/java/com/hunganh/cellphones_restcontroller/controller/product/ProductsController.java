package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.CProductDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductBox;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "")
    public ResponseEntity<List<ProductBox>> getTopItemsByCategory (
            @RequestParam("category") String categoryName,
            @RequestParam(name = "limit") int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit value must not be less than one");
        }
        return ResponseEntity.ok(productService.getTopItemsByCategory(categoryName, limit));
    }

    @GetMapping(value = "{id}")
    public  ResponseEntity<ProductInfo> getProductDetail(@PathVariable(name = "id") short id) {
        return null;
    }

//    @GetMapping(value = "")
//    public ResponseEntity<List<ProductInfo>> getAllProduct() {
//        List<ProductInfo> db = this.productService.getAll();
//        return ResponseEntity.ok(db);
//    }

    @PostMapping(value = "")
    public ResponseEntity<ProductInfo> createProduct(@RequestBody CProductDTO dto) {
        return ResponseEntity.ok(productService.save(dto));
    }

    @PutMapping(value = "{id}")
    public  ResponseEntity<ProductInfo> updateProduct(
            @PathVariable(name = "id") short id
            , @RequestBody CProductDTO dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @PutMapping(value = "{id}/specification")
    public ResponseEntity<ProductInfo> updateProductSpecification( @PathVariable String id,
                                                                   @RequestBody String specification) {
        return ResponseEntity.ok(productService.updateProductSpecification(id, specification));
    }
}
