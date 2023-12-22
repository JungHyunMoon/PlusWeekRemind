package com.sparta.plusweekremind.comment.service;

import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.board.repository.BoardRepository;
import com.sparta.plusweekremind.comment.dto.CommentRequestDto;
import com.sparta.plusweekremind.comment.dto.CommentUpdateRequestDto;
import com.sparta.plusweekremind.comment.entity.Comment;
import com.sparta.plusweekremind.comment.repository.CommentRepository;
import com.sparta.plusweekremind.user.entity.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Comment createComment(CommentRequestDto commentRequestDto, User user) {
        Optional<Board> board = boardRepository.findById(commentRequestDto.boardId());

        Comment comment = commentRequestDto.toEntity(board.get(), user);

        return commentRepository.save(comment);
    }

    public Comment updateComment(CommentUpdateRequestDto commentUpdateRequestDto, User user) {
        Optional<Comment> optionalComment = commentRepository.findById(commentUpdateRequestDto.commentId());

        Comment comment = optionalComment.get();
        comment.updateComment(comment.getCommentContent());

        return comment;
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}