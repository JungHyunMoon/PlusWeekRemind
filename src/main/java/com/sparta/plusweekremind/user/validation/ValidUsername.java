package com.sparta.plusweekremind.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {
    String message() default "닉네임은 최소 3자 이상, 알파벳 대소문자와 숫자가 포함되어야 합니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
