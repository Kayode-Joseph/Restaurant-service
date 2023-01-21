package com.kayode.restaurantservice.web.dtos.dish;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishRequest {

    private MultipartFile dishPicture;

    private String dishName;

    private String description;

}
