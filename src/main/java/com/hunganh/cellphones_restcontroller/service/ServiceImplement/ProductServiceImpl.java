package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.dto.request.product.CProductDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductBox;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductInfo;
import com.hunganh.cellphones_restcontroller.entity.product.Brand;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductCategory;
import com.hunganh.cellphones_restcontroller.entity.product.ProductSubcategory;
import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.repository.product.BrandRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductCategoryRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductSubcategoryRepository;
import com.hunganh.cellphones_restcontroller.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Autowired
    private ProductSubcategoryRepository subcategoryRepository;

    private static final String BRAND_NOT_FOUND = "The Brand is not found";
    private static final String CATEGORY_NOT_FOUND = "The Category is not found";
    private static final String SUBCATEGORY_NOT_FOUND = "The Sub-Category is not found";
    private static final String PRODUCT_NOT_FOUND = "The Product is not found";

    @Override
    public List<ProductInfo> getAll() {
        return this.productRepository.findAllBy();
    }

    @Override
    public ProductInfo save(CProductDTO dto) {
        Product product = convert(dto);
        Brand brand = brandRepository.findById(dto.getBrandId()).orElseThrow(
                () -> new ResourceNotFoundException(BRAND_NOT_FOUND)
        );
        product.setBrand(brand);
        ProductCategory category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException(CATEGORY_NOT_FOUND)
        );
        product.setCategory(category);
        ProductSubcategory subcategory = subcategoryRepository.findById(dto.getSubcategoryId()).orElseThrow(
                () -> new ResourceNotFoundException(SUBCATEGORY_NOT_FOUND)
        );
        product.setSubcategory(subcategory);
        return getInfo(productRepository.save(product));
    }

    @Override
    public ProductInfo update(short id, CProductDTO dto) {
        // Retrieve Product from database by id
        Product dbProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(PRODUCT_NOT_FOUND)
        );
        Product update = convert(dto);
        if (dbProduct.getBrandId() != dto.getBrandId()) {
            Brand brand = brandRepository.findById(dto.getBrandId()).orElseThrow(
                    () -> new ResourceNotFoundException(BRAND_NOT_FOUND)
            );
            update.setBrand(brand);
        } else {
            update.setBrand(dbProduct.getBrand());
        }
        if (dbProduct.getCategoryId() != dto.getCategoryId()) {
            ProductCategory category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(
                    () -> new ResourceNotFoundException(CATEGORY_NOT_FOUND)
            );
            update.setCategory(category);
        } else {
            update.setCategory(dbProduct.getCategory());
        }
        if (dbProduct.getSubcategoryId() != dto.getSubcategoryId()) {
            ProductSubcategory subcategory = subcategoryRepository.findById(dto.getSubcategoryId()).orElseThrow(
                    () -> new ResourceNotFoundException(SUBCATEGORY_NOT_FOUND)
            );
            update.setSubcategory(subcategory);
        } else {
            update.setSubcategory(dbProduct.getSubcategory());
        }
        return this.getInfo(productRepository.save(update));
    }

    @Override
    public ProductInfo updateProductSpecification(String productId, String specification) {
        Product product = productRepository.findById(Short.valueOf(productId)).orElseThrow(
                () -> new ResourceNotFoundException(PRODUCT_NOT_FOUND)
        );
        product.setProductSpecification(specification);
        return this.getInfo(productRepository.save(product));
    }

    @Override
    public List<ProductBox> getTopItemsByCategory(String categoryName, int limit)
            throws ResourceNotFoundException {
        Pageable pageable = PageRequest.of(0, limit);
        ProductCategory category = categoryRepository.findByName(categoryName);
        if (category == null) {
            throw (new ResourceNotFoundException(CATEGORY_NOT_FOUND));
        }
        return productRepository.findAllByCategoryOrderByModifiedDateDesc(category, pageable);
    }

    private Sort getSort(String sortColumn, boolean sortAsc) {
        Sort.Direction direction = sortAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        return Sort.by(direction, sortColumn);
    }

    private ProductInfo getInfo(Product p) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        return pf.createProjection(ProductInfo.class, p);
    }

    private Product convert(CProductDTO dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setUnitPrice(dto.getUnitPrice());
        p.setStandardCost(dto.getStandardCost());
        p.setType(dto.getType());
        p.setDiscount(dto.getDiscount());
        return p;
    }
}
