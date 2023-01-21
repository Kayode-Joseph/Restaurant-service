package com.kayode.restaurantservice.web.dtos.restaurant;

import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.validators.latitudeValidator.Latitude;
import com.kayode.restaurantservice.web.dtos.validators.longitudeValidator.Longitude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponse {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Latitude()
    private double latitude;

    @Longitude()
    private double longitude;

    private String address;

    private UUID publicId;

    private String logoURL;
}
