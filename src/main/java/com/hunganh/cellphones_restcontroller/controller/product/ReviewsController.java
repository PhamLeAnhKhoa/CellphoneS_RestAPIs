package com.hunganh.cellphones_restcontroller.controller.product;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductReviewDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductReviewInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "reviews")
public class ReviewsController {

    @Autowired
    private ProductReviewService reviewService;

    /**
     * PRODUCT REVIEW APIs
     */

    @GetMapping(value = "")
    public ResponseEntity<List<ProductReviewInfo>> getReviews() {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<ProductReviewInfo> addReview(@RequestBody ProductReviewDTO dto) {
        return ResponseEntity.ok(reviewService.save(dto));
    }

    @PutMapping(value = "")
    public ResponseEntity<ProductReviewInfo> updateReview(@RequestBody ProductReviewDTO dto) {
        return ResponseEntity.ok(reviewService.update(dto));
    }
}
