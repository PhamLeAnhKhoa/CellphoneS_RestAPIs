package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductReview;
import com.hunganh.cellphones_restcontroller.entity.utils.ConvertToEntity;
import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.repository.product.ProductRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductReviewRepository;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductReviewDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductReviewInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConvertToEntity convertor;

    private final String REVIEW_NOT_FOUND = "The Product review is not found";
    private final String PRODUCT_NOT_FOUND = "The Product is not found";

    @Override
    public List<ProductReviewInfo> getAll() {
        return reviewRepository.findAllBy();
    }

    @Override
    public ProductReviewInfo save(ProductReviewDTO dto) {
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(
                () -> new ResourceNotFoundException(PRODUCT_NOT_FOUND)
        );
        ProductReview entity = convertor.ToEntity(dto);
        System.out.println(entity.toString());
//        entity.setProduct(product);
        System.out.println(entity.toString());
        return this.getInfo(reviewRepository.save(entity));
    }

    @Override
    public ProductReviewInfo update(ProductReviewDTO dto) {
//        ProductReview entity = reviewRepository.findById(dto.getId()).orElseThrow(
//                () -> new ResourceNotFoundException(REVIEW_NOT_FOUND)
//        );
//        entity = convertor.ToEntity(entity, dto);
//        return this.getInfo(reviewRepository.save(entity));
        return null;
    }

    private ProductReviewInfo getInfo(ProductReview entity) {
        return new SpelAwareProxyProjectionFactory().createProjection(ProductReviewInfo.class, entity);
    }
}
