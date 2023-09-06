package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.dto.request.product.ProductSubcategoryDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductSubcategoryInfo;
import com.hunganh.cellphones_restcontroller.entity.product.ProductCategory;
import com.hunganh.cellphones_restcontroller.entity.product.ProductSubcategory;
import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.repository.product.ProductCategoryRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductSubcategoryRepository;
import com.hunganh.cellphones_restcontroller.service.product.ProductSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSubcategoryServiceImpl implements ProductSubcategoryService {

    @Autowired
    private ProductSubcategoryRepository subcategoryRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

//    @Autowired
//    private ProductCategorySubcategoryRepository categorySubcategoryRepository;

    @Override
    public List<ProductSubcategoryInfo> getAll() {
        return this.subcategoryRepository.findAllBy();
    }

    @Override
    public ProductSubcategoryInfo save(ProductSubcategoryDTO dto) {
        ProductCategory category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException("Could not found category", new  Throwable("404"))
        );
        ProductSubcategory subcategory = new ProductSubcategory();
        subcategory.setName(dto.getName());
        subcategory.setCategory(category);
//        ProductCategorySubcategory categorySubcategory = new ProductCategorySubcategory();
//        categorySubcategory.setCategory(category);
//        categorySubcategory.setSubcategory(subcategory);
        return this.getInfo(subcategoryRepository.save(subcategory));
    }

    @Override
    public ProductSubcategoryInfo update(short id, String name) {
        ProductSubcategory subcategory = subcategoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not found sub-category: " + name)
        );
        subcategory.setName(name);
        return this.getInfo(subcategoryRepository.save(subcategory));
    }

    private ProductSubcategoryInfo getInfo(ProductSubcategory subcategory) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        ProductSubcategoryInfo info = pf.createProjection(ProductSubcategoryInfo.class, subcategory);
        return info;
    }
}
