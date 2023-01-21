package com.kayode.restaurantservice.web.dtos.dish;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishResponse {
    private String publicId;

    private String dishName;

    private String description;

    private String dishPhotoURL;

}
