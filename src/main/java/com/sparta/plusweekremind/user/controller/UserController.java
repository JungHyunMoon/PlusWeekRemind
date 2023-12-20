package com.sparta.plusweekremind.user.controller;

import com.sparta.plusweekremind.common.exception.CustomException;
import com.sparta.plusweekremind.common.jwt.JwtUtil;
import com.sparta.plusweekremind.user.dto.request.SignRequestDto;
import com.sparta.plusweekremind.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignRequestDto requestDto) throws CustomException {
        userService.signup(requestDto);
        return new ResponseEntity<>("회원가입 성공", HttpStatus.CREATED);
    }

    @PostMapping("/isAlreadyExistUserName")
    public Boolean isAlreadyExistUserName(@RequestHeader String username) {
        return userService.isAlreadyExistUserName(username);
    }

}