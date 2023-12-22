package com.sparta.plusweekremind.common.service;

import ch.qos.logback.core.util.FixedDelay;
import com.sparta.plusweekremind.board.repository.BoardRepository;
import com.sparta.plusweekremind.comment.repository.CommentRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchdulerService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Scheduled(cron = "0 53 16 * * *") // 매일 오후 4시 40분에 실행
    public void run() {
        LocalDateTime thresholdDate = LocalDateTime.now().minusDays(1);

        long countBeforeBoard = boardRepository.countByModifiedAtBefore(thresholdDate);
        log.info("삭제될 Board 데이터 수: {}", countBeforeBoard);

        // Board 테이블에서 하루 이전 데이터 삭제
        boardRepository.deleteAllByModifiedAtBefore(thresholdDate);

        // Comment 테이블에서 90일 이전 데이터 삭제
//        commentRepository.deleteAllByCreatedAtBefore(thresholdDate);

    }
}
