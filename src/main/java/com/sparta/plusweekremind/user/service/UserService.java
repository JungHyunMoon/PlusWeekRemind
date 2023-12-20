package com.sparta.plusweekremind.user.service;

import com.sparta.plusweekremind.common.exception.CustomException;
import com.sparta.plusweekremind.common.exception.ErrorCode;
import com.sparta.plusweekremind.common.jwt.JwtUtil;
import com.sparta.plusweekremind.common.security.UserDetailsServiceImpl;
import com.sparta.plusweekremind.user.dto.request.SignRequestDto;
import com.sparta.plusweekremind.user.entity.User;
import com.sparta.plusweekremind.user.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;

    public void signup(SignRequestDto requestDto) throws CustomException {
        String username = requestDto.username();
        String password = passwordEncoder.encode(requestDto.password());

        Optional<User> duplicateUser = userRepository.findByUsername(username);
        if (duplicateUser.isPresent()) {
            throw new CustomException(ErrorCode.DUPLICATED_USERNAME);
        }

        User user = new User(username, password);
        userRepository.save(user);
    }

    public Boolean isAlreadyExistUserName(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

//    public void signin(SignRequestDto requestDto, HttpServletResponse response) throws CustomException {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(requestDto.getUsername());
//        if (!passwordEncoder.matches(requestDto.getPassword(), userDetails.getPassword())) {
//            throw new CustomException(ErrorCode.BAD_PARAMETER);
//        }
//    }

}