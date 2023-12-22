package com.sparta.plusweekremind.comment.repository;

import com.sparta.plusweekremind.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
