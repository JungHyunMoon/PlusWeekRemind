package com.sparta.plusweekremind.common.validation;

import com.sparta.plusweekremind.dto.request.SignRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordValidator implements ConstraintValidator<ValidPassword, SignRequestDto> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(SignRequestDto signRequestDto, ConstraintValidatorContext context) {
        if (signRequestDto.password() == null || signRequestDto.username() == null) {
            return false;
        }

        boolean isLengthSufficient = signRequestDto.password().length() >= 4;
        boolean isNicknameIncluded = signRequestDto.password().contains(signRequestDto.username());

        return isLengthSufficient && !isNicknameIncluded;
    }
}
