package com.sparta.plusweekremind.board.entity;

import com.sparta.plusweekremind.common.model.Timestamped;
import com.sparta.plusweekremind.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // 이미지 경로를 저장할 필드
    private String imagePath;

    public void update(Board updateBoard) {
        title = updateBoard.title;
        content = updateBoard.content;
        imagePath = updateBoard.imagePath;
    }
}
