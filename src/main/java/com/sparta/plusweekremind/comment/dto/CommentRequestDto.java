package com.sparta.plusweekremind.comment.dto;

import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.comment.entity.Comment;
import com.sparta.plusweekremind.user.entity.User;

public record CommentRequestDto(
    Long boardId,
    String commentContent
) {
    public Comment toEntity (Board board, User user) {
        return Comment.builder()
            .commentContent(commentContent)
            .user(user)
            .board(board)
            .build();
    }
}