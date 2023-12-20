package com.sparta.plusweekremind.controller;

import com.sparta.plusweekremind.common.exception.CustomException;
import com.sparta.plusweekremind.common.jwt.JwtUtil;
import com.sparta.plusweekremind.dto.request.SignRequestDto;
import com.sparta.plusweekremind.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

//    @PostMapping("/signin")
//    public ResponseEntity<String> signin(@Valid @RequestBody SignupRequestDto requestDto, HttpServletResponse response) throws CustomException {
//        userService.signin(requestDto, response);
//        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
//    }

}