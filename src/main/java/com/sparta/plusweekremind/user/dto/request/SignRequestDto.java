package com.sparta.plusweekremind.user.dto.request;

import com.sparta.plusweekremind.user.validation.ValidPassword;
import com.sparta.plusweekremind.user.validation.ValidUsername;

@ValidUsername
@ValidPassword
public record SignRequestDto(
    String username,
    String password
) {

}