package com.sparta.plusweekremind.comment.controller;

import com.sparta.plusweekremind.comment.dto.CommentRequestDto;
import com.sparta.plusweekremind.comment.dto.CommentUpdateRequestDto;
import com.sparta.plusweekremind.comment.entity.Comment;
import com.sparta.plusweekremind.comment.service.CommentService;
import com.sparta.plusweekremind.common.dto.ApiResponseDto;
import com.sparta.plusweekremind.common.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/comments")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ApiResponseDto<?> createComment(
        @RequestBody CommentRequestDto commentRequestDto,
        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Comment comment = commentService.createComment(commentRequestDto,
            userDetails.getUser());

        return new ApiResponseDto<>("댓글 생성 완료", 200, comment);
    }

    @PatchMapping("/{commentId}")
    public ApiResponseDto<?> updateComment(@PathVariable Long commentId,
        @RequestBody CommentUpdateRequestDto commentUpdateRequestDto,
        @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Comment comment = commentService.updateComment(commentUpdateRequestDto, userDetails.getUser());

        return new ApiResponseDto<>("댓글 수정 완료", 200, comment);

    }


    @DeleteMapping("/{commentId}")
    public ApiResponseDto<?> deleteComment(@PathVariable Long commentId,
        @AuthenticationPrincipal UserDetailsImpl userDetails) {

        commentService.deleteComment(commentId);
        return new ApiResponseDto<>("댓글 수정 완료", 200, null);
    }

}