package com.sparta.plusweekremind.dto.request;

import com.sparta.plusweekremind.common.validation.ValidPassword;
import com.sparta.plusweekremind.common.validation.ValidUsername;

@ValidUsername
@ValidPassword
public record SignRequestDto(
    String username,
    String password
) {

}