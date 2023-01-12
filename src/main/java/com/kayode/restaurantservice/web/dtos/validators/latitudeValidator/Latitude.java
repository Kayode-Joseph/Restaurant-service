package com.kayode.restaurantservice.web.dtos.validators.latitudeValidator;


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
@Constraint(validatedBy = LatitudeValidator.class)
public @interface Latitude {
    //error message
    public String message() default "Invalid Latitude: latitude must be a numeric value between 90 and -90";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
