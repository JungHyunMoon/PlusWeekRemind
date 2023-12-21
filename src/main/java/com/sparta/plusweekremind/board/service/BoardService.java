package com.sparta.plusweekremind.board.service;

import com.sparta.plusweekremind.board.dto.CreateBoardDto.CreateBoardDto;
import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.board.repository.BoardRepository;
import com.sparta.plusweekremind.common.utils.FileStorageService;
import com.sparta.plusweekremind.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final FileStorageService fileStorageService;

    public Board createBoard(User user, CreateBoardDto createBoardDto, MultipartFile file) {

        String multipartUrl = fileStorageService.storeFile(file);
        Board board = createBoardDto.toEntity(user, multipartUrl);
        boardRepository.save(board);
        return board;

    }

}
