package com.sparta.plusweekremind.like.service;

import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.board.repository.BoardRepository;
import com.sparta.plusweekremind.comment.entity.Comment;
import com.sparta.plusweekremind.comment.repository.CommentRepository;
import com.sparta.plusweekremind.like.entity.UserBoardLike;
import com.sparta.plusweekremind.like.entity.UserCommentLike;
import com.sparta.plusweekremind.like.repository.UserBoardLikeRepository;
import com.sparta.plusweekremind.like.repository.UserCommentLikeRepository;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserBoardLikeRepository userBoardLikeRepository;
    private final UserCommentLikeRepository userCommentLikeRepository;

    @Transactional
    public void createLikeBoard(User user, Long boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);

        UserBoardLike userBoardLike = UserBoardLike.fromUserAndBoard(user, optionalBoard.get());

        userBoardLikeRepository.save(userBoardLike);
    }

    @Transactional
    public void deleteLikeBoard(User user, Long boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);

        UserBoardLike userBoardLike = UserBoardLike.fromUserAndBoard(user, optionalBoard.get());

        userBoardLikeRepository.deleteById(userBoardLike.getUserBoardLikeId());
    }

    @Transactional
    public void createLikeComment(User user, Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        UserCommentLike userCommentLike = UserCommentLike.fromUserAndBoard(user,
            optionalComment.get());

        userCommentLikeRepository.save(userCommentLike);
    }

    @Transactional
    public  void deleteLikeComment(User user, Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        UserCommentLike userCommentLike = UserCommentLike.fromUserAndBoard(user,
            optionalComment.get());

        userCommentLikeRepository.deleteById(userCommentLike.getUserCommentLikeId());
    }
}
