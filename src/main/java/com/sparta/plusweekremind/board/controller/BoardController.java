package com.sparta.plusweekremind.board.controller;

import com.sparta.plusweekremind.board.dto.CreateBoardDto.CreateBoardDto;
import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.board.service.BoardService;
import com.sparta.plusweekremind.common.dto.ApiResponseDto;
import com.sparta.plusweekremind.common.exception.CustomException;
import com.sparta.plusweekremind.common.security.UserDetailsImpl;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
        return new ApiResponseDto<>("게시글이 생성 되었습니다", 201, board);
    }

    @GetMapping()
    public ApiResponseDto<?> getSortedBoards(
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "5") int size,
        @RequestParam(name = "sortBy", defaultValue = "createdAt") String sortBy,
        @RequestParam(name = "order", defaultValue = "ASC") String order) {

        List<Board> boards = boardService.getBoardSorted(page, size, sortBy, order).getContent();

        return new ApiResponseDto<>("게시글 목록 조회 성공", 200, boards);
    }

    @GetMapping("/{boardId}")
    public ApiResponseDto<?> getBoardById(@PathVariable Long boardId) throws CustomException {
        Board board = boardService.getBoardById(boardId);

        return new ApiResponseDto<>("게시글 조회 성공", 200, boardId);
    }
}
