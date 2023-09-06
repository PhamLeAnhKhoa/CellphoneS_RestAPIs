package com.hunganh.cellphones_restcontroller.repository.content;

import com.hunganh.cellphones_restcontroller.entity.content.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}