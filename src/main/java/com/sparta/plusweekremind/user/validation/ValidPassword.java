package com.sparta.plusweekremind.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    Class<?>[] groups() default {};
    String message() default "닉네임을 포함하지 않는 4자 이상 비밀번호를 입력하세요.";
    Class<? extends Payload>[] payload() default {};
}
