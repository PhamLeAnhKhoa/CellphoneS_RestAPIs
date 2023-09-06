package com.hunganh.cellphones_restcontroller.repository.content;

import com.hunganh.cellphones_restcontroller.entity.content.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}