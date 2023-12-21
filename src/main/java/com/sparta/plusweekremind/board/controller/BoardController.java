package com.sparta.plusweekremind.board.controller;

import com.sparta.plusweekremind.board.dto.CreateBoardDto.CreateBoardDto;
import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.board.service.BoardService;
import com.sparta.plusweekremind.common.dto.ApiResponseDto;
import com.sparta.plusweekremind.common.security.UserDetailsImpl;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping()
    public ApiResponseDto<?> createBoard(@AuthenticationPrincipal UserDetailsImpl userDetails,
        @Valid @ModelAttribute CreateBoardDto createBoardDto,
        @RequestParam("file") MultipartFile file) {
        User user = userDetails.getUser();
        // 게시글 생성 로직을 여기에 구현합니다.
        Board board = boardService.createBoard(user, createBoardDto, file);
        return new ApiResponseDto<>("게시글이 생성되었습니다", 201, board);
    }

    // 다른 메서드들 ...
}
