package com.kayode.restaurantservice.web.dtos;

import com.kayode.restaurantservice.web.dtos.validators.latitudeValidator.Latitude;
import com.kayode.restaurantservice.web.dtos.validators.longitudeValidator.Longitude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Latitude()
    private double latitude;

    @Longitude()
    private double longitude;

    @NotBlank(message = "Address cannot be blank")
    private String address;

}
