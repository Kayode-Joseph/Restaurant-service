package com.kayode.restaurantservice.web.controllers;

import com.kayode.restaurantservice.service.RestaurantService;
import com.kayode.restaurantservice.web.dtos.CreateRestaurantRequest;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public String createRestaurant(@Valid @RequestBody @NonNull CreateRestaurantRequest createRestaurantRequest) {

        return restaurantService.createRestaurant(createRestaurantRequest);

    }
}
