package com.kayode.restaurantservice.web.dtos.restaurant;

import com.kayode.restaurantservice.web.dtos.validators.latitudeValidator.Latitude;
import com.kayode.restaurantservice.web.dtos.validators.longitudeValidator.Longitude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantRequest {

    private MultipartFile restaurantLogo;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Latitude()
    private double latitude;

    @Longitude()
    private double longitude;

    @NotBlank(message = "Address cannot be blank")
    private String address;

}
