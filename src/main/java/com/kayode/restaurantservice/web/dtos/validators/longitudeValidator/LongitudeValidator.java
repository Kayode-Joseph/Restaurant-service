package com.kayode.restaurantservice.web.dtos.validators.longitudeValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LongitudeValidator implements ConstraintValidator<Longitude, Double> {

    private static final int LONGITUDE_LOWER_BOUND=-180;
    private static final int LONGITUDE_UPPER_BOUND=180;

    @Override
    public boolean isValid(Double longitude, ConstraintValidatorContext constraintValidatorContext) {


        if(longitude>=LONGITUDE_LOWER_BOUND && longitude<=LONGITUDE_UPPER_BOUND){
            return true;
        }

        return false;
    }
}
