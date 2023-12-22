package com.sparta.plusweekremind.board.repository;

import com.sparta.plusweekremind.board.entity.Board;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    long countByModifiedAtBefore(LocalDateTime dateTime);

    @Transactional
    void deleteAllByModifiedAtBefore(LocalDateTime date);


}
