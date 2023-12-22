package com.sparta.plusweekremind.comment.repository;

import com.sparta.plusweekremind.comment.entity.Comment;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    long countByCreatedAtBefore(LocalDateTime dateTime);

    @Transactional
    void deleteAllByCreatedAtBefore(LocalDateTime date);

}
