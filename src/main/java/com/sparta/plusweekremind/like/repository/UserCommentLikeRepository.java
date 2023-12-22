package com.sparta.plusweekremind.like.repository;

import com.sparta.plusweekremind.like.entity.UserCommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentLikeRepository extends JpaRepository<UserCommentLike, Long> {

}
