package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductPhotoDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductPhotoInfo;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductPhoto;
import com.hunganh.cellphones_restcontroller.entity.utils.ConvertToEntity;
import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.repository.product.ProductPhotoRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductRepository;
import com.hunganh.cellphones_restcontroller.service.product.ProductPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

    @Autowired
    private ConvertToEntity convertor;

    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    @Autowired
    private ProductRepository productRepository;

    private final String PHOTO_NOT_FOUND = "The Product photo is not found";

    @Override
    public List<ProductPhotoInfo> getAll() {
        return productPhotoRepository.findAllBy();
    }

    @Override
    public ProductPhotoInfo save(ProductPhotoDTO dto) {
        ProductPhoto entity = convertor.ToEntity(dto);
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(
                () -> new ResourceNotFoundException("Product not found")
        );
        entity.setProduct(product);
        return this.getInfo(productPhotoRepository.save(entity));
    }

    @Override
    public ProductPhotoInfo update(ProductPhotoDTO dto) {
//        productPhotoRepository.findById(dto.getId()).orElseThrow(
//                () -> new ResourceNotFoundException(PHOTO_NOT_FOUND)
//        );
//        ProductPhoto update = convertor.ToEntity(dto);
//        return this.getInfo(productPhotoRepository.save(update));
        return null;
    }

    private ProductPhotoInfo getInfo(ProductPhoto entity) {
        return new SpelAwareProxyProjectionFactory().createProjection(ProductPhotoInfo.class, entity);
    }
}
