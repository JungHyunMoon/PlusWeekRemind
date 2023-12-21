package com.sparta.plusweekremind.board.service;

import com.sparta.plusweekremind.board.dto.request.BoardDto;
import com.sparta.plusweekremind.board.entity.Board;
import com.sparta.plusweekremind.board.repository.BoardRepository;
import com.sparta.plusweekremind.common.exception.CustomException;
import com.sparta.plusweekremind.common.exception.ErrorCode;
import com.sparta.plusweekremind.common.utils.FileStorageService;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final FileStorageService fileStorageService;

    @Transactional
    public Board createBoard(User user, BoardDto boardDto, MultipartFile file) {

        String multipartUrl = fileStorageService.storeFile(file);
        Board board = boardDto.toEntity(user, multipartUrl);
        boardRepository.save(board);
        return board;

    }

    public Page<Board> getBoardSorted(int page, int size, String sortBy, String order) {
        Sort.Direction direction = Sort.Direction.fromString(order);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return boardRepository.findAll(pageable);
    }

    public Board getBoardById(Long boardId) throws CustomException {
        Optional<Board> board = boardRepository.findById(boardId);

        if (board.isEmpty()) {
            throw new CustomException(ErrorCode.BOARD_NOT_FOUND);
        }

        return board.get();
    }

    @Transactional
    public Board updateBoard(User user, Long boardId, BoardDto boardDto, MultipartFile file) throws CustomException {
        Optional<Board> board = boardRepository.findById(boardId);

        if (board.isEmpty()) {
            throw new CustomException(ErrorCode.BOARD_NOT_FOUND);
        }

        if (board.get().getUser().equals(user)) {
            throw new CustomException(ErrorCode.NO_AUTHORIZATION);
        }

        String multipartUrl = fileStorageService.storeFile(file);
        board.get().update(boardDto.toEntity(user, multipartUrl));

        return board.get();
    }

}
