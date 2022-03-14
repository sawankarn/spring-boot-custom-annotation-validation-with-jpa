package com.java.puzzle.springbootrestapivalidation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidUserValidator.class)
public @interface ValidUser {
    public String message() default "Invalid user";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
