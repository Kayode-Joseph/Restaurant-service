package com.kayode.restaurantservice.web.dtos.validators.longitudeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LongitudeValidator.class)
public @interface Longitude {
    //error message
    public String message() default "Invalid Longitude: longitude must be a numeric value between 180 and 180";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
