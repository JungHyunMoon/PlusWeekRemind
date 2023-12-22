package com.sparta.plusweekremind.like.entity;

import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBoardLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userBoardLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    public static UserBoardLike fromUserAndBoard(User user, Board board) {
        return UserBoardLike.builder()
            .user(user)
            .board(board)
            .build();
    }

}
