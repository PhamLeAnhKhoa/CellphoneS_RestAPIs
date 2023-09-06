package com.hunganh.cellphones_restcontroller.repository.product;

import com.hunganh.cellphones_restcontroller.entity.product.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Short> {
}