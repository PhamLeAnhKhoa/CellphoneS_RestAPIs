package com.hunganh.cellphones_restcontroller.repository.content;

import com.hunganh.cellphones_restcontroller.entity.content.PostCategorySubcategory;
import com.hunganh.cellphones_restcontroller.entity.content.identity.PostCategorySubcategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategorySubcategoryRepository extends JpaRepository<PostCategorySubcategory, PostCategorySubcategoryId> {
}