package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import com.hunganh.cellphones_restcontroller.entity.product.Product;
import com.hunganh.cellphones_restcontroller.entity.product.ProductDescription;
import com.hunganh.cellphones_restcontroller.entity.product.identity.ProductDescriptionId;
import com.hunganh.cellphones_restcontroller.entity.utils.ConvertToEntity;
import com.hunganh.cellphones_restcontroller.exception.ResourceNotFoundException;
import com.hunganh.cellphones_restcontroller.repository.humanresources.EmployeeAccountRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductDescriptionRepository;
import com.hunganh.cellphones_restcontroller.repository.product.ProductRepository;
import com.hunganh.cellphones_restcontroller.dto.request.product.ProductDescriptionDTO;
import com.hunganh.cellphones_restcontroller.dto.response.product.ProductDescriptionInfo;
import com.hunganh.cellphones_restcontroller.service.product.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Autowired
    private ConvertToEntity convertor;

    @Autowired
    private ProductDescriptionRepository descriptionRepository;

    @Autowired
    private EmployeeAccountRepository employeeAccountRepository;

    @Autowired
    private ProductRepository productRepository;

    private final String PRODUCT_NOT_FOUND = "The product is not found";
    private final String EMPLOYEE_ACCOUNT_NOT_FOUND = "The employee account is not found";
    private final String DESCRIPTION_NOT_FOUND = "The product description is not found";

    @Override
    public List<ProductDescriptionInfo> getAll() {
        return this.descriptionRepository.findAllBy();
    }

    @Override
    public ProductDescriptionInfo save(ProductDescriptionDTO dto) {
        ProductDescription entity = convertor.ToEntity(dto);
        EmployeeAccount author = employeeAccountRepository.findById(dto.getAuthorId()).orElseThrow(
                () -> new ResourceNotFoundException(EMPLOYEE_ACCOUNT_NOT_FOUND)
        );
        entity.setAuthor(author);
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(
                () -> new ResourceNotFoundException(PRODUCT_NOT_FOUND)
        );
        entity.setProduct(product);
        return this.getInfo(descriptionRepository.save(entity));
    }

    @Override
    public ProductDescriptionInfo update(ProductDescriptionDTO dto) {
        ProductDescriptionId id = new ProductDescriptionId(dto.getProductId(), dto.getAuthorId());
        ProductDescription entity = descriptionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(DESCRIPTION_NOT_FOUND)
        );
        entity.setDescription(dto.getDescription());
        return this.getInfo(descriptionRepository.save(entity));
    }

    private ProductDescriptionInfo getInfo(ProductDescription entity) {
        return new SpelAwareProxyProjectionFactory().createProjection(ProductDescriptionInfo.class, entity);
    }
}
