package com.sparta.plusweekremind.board.dto.CreateBoardDto;

import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.validation.constraints.Size;

public record CreateBoardDto(
    @Size(max = 500, message = "제목은 500자 이내로 입력해주세요.") String title,
    @Size(max = 5000, message = "내용은 5000자 이내로 입력해주세요.") String content
) {

    public Board toEntity(User user, String multipartUrl) {
        return Board.builder()
            .title(title)
            .content(content)
            .imagePath(multipartUrl)
            .user(user)
            .build();
    }
}
