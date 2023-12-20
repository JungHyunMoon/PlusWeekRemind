package com.sparta.plusweekremind.common.validation;

import com.sparta.plusweekremind.dto.request.SignRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UsernameValidator implements ConstraintValidator<ValidUsername, SignRequestDto> {

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(SignRequestDto signRequestDto, ConstraintValidatorContext context) {
        return signRequestDto.username() != null && signRequestDto.username().matches("[a-zA-Z0-9]{3,}");
    }
}

