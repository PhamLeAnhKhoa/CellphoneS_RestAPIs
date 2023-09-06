package com.hunganh.cellphones_restcontroller.entity.content;

import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "Post")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_brief", length = 500)
    private String brief;

    @Column(name = "post_content", columnDefinition = "BLOB")
    private String Content;

    @Column(name = "img_url", length = 1000, nullable = false)
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private EmployeeAccount author;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private List<PostCategorySubcategory> categorySubcategories;

}
