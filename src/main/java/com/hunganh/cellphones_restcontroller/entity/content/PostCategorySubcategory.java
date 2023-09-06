package com.hunganh.cellphones_restcontroller.entity.content;

import com.hunganh.cellphones_restcontroller.entity.content.identity.PostCategorySubcategoryId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Post_Category_Subcategory")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(PostCategorySubcategoryId.class)
public class PostCategorySubcategory {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id") // modified May 22nd, 2023

    private Subcategory subcategory;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
