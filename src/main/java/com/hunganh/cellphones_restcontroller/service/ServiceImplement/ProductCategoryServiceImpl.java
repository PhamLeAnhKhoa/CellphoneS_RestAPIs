package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.entity.product.ProductCategory;
import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductCategoryDTO;
import com.hunganh.cellphones_restcontroller.repository.product.ProductCategoryRepository;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductCategoryInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategoryInfo> getAll() {
        return this.productCategoryRepository.findAllProductCategoryBy();
    }

    @Override
    public ProductCategoryInfo getById(Short id) {
        ProductCategory category = productCategoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Product category with Id %d not found", id))
        );
        return this.getInfo(category);
    }

    @Override
    public ProductCategoryInfo update(ProductCategoryDTO dto) {
        ProductCategory productCategory = productCategoryRepository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Product category is not found: %s", dto.getName()))
        );
        productCategory.setName(dto.getName());
        return this.getInfo(productCategoryRepository.save(productCategory));
    }

    @Override
    public ProductCategoryInfo save(String name) {
        ProductCategory category = new ProductCategory();
        category.setName(name);
        return this.getInfo(productCategoryRepository.save(category));
    }

    private ProductCategoryInfo getInfo(ProductCategory category) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        return pf.createProjection(ProductCategoryInfo.class, category);
    }
}
