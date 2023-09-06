package com.hunganh.cellphones_restcontroller.entity.content.identity;

import com.hunganh.cellphones_restcontroller.entity.content.Category;
import com.hunganh.cellphones_restcontroller.entity.content.Post;
import com.hunganh.cellphones_restcontroller.entity.content.Subcategory;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostCategorySubcategoryId implements Serializable {
    private Post post;
    private Category category;
    private Subcategory subcategory;
}
