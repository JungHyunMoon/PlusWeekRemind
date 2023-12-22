package com.sparta.plusweekremind.like.controller;

import com.sparta.plusweekremind.common.security.UserDetailsImpl;
import com.sparta.plusweekremind.like.service.LikeService;
import com.sparta.plusweekremind.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

  private final LikeService likeService;

  @PostMapping("/board/{boardId}/like")
  public ResponseEntity<?> likeBoard(@PathVariable Long boardId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
    likeService.createLikeBoard(user, boardId);

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

  @DeleteMapping("/board/{boardId}/like")
  public ResponseEntity<?> deleteLikeBoard(@PathVariable Long boardId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
    likeService.deleteLikeBoard(user, boardId);

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

  @PostMapping("/comments/{commentId}/like")
  public ResponseEntity<?> likeComment(@PathVariable Long commentId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
    likeService.createLikeComment(user, commentId);

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

  @DeleteMapping("/comment/{boardId}/like")
  public ResponseEntity<?> deleteLikeComment(@PathVariable Long commentId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    User user = userDetails.getUser();
    likeService.deleteLikeComment(user, commentId);

    return ResponseEntity.status(HttpStatus.CREATED).body("요청 성공");
  }

}
