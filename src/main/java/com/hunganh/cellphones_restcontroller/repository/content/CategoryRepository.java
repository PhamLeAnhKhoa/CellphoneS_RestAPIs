package com.hunganh.cellphones_restcontroller.repository.content;

import com.hunganh.cellphones_restcontroller.entity.content.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}