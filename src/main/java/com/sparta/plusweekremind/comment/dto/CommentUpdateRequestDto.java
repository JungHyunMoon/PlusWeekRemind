package com.sparta.plusweekremind.comment.dto;

public record CommentUpdateRequestDto(
    Long commentId,
    String content
) {

}