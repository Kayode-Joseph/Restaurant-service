package com.kayode.restaurantservice.web.dtos.validators.latitudeValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LatitudeValidator implements ConstraintValidator<Latitude,Double> {

    private static final int LATITUDE_LOWER_BOUND=-90;
    private static final int LATITUDE_UPPER_BOUND=90;


    @Override
    public boolean isValid(Double latitude, ConstraintValidatorContext constraintValidatorContext) {
        if(latitude>=LATITUDE_LOWER_BOUND && latitude<=LATITUDE_UPPER_BOUND){
            return true;
        }
        return false;
    }
}
