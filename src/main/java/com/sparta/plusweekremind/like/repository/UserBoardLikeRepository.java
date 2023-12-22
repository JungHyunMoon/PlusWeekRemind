package com.sparta.plusweekremind.like.repository;

import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.user.entity.User;
import com.sparta.plusweekremind.like.entity.UserBoardLike;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBoardLikeRepository extends JpaRepository<UserBoardLike, Long> {

    Optional<UserBoardLike> findByUserAndBoard(User user, Board board);

    void deleteByUserAndBoard(User user, Board board);

}
