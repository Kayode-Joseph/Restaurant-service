package com.kayode.restaurantservice.web.controllers;


import com.kayode.restaurantservice.services.RestaurantService;
import com.kayode.restaurantservice.web.dtos.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.RestaurantResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse createRestaurant(@Valid @RequestBody @NonNull RestaurantRequest restaurantRequest) {

        return restaurantService.createRestaurant(restaurantRequest);

    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponse getRestaurant(@PathVariable("uuid") UUID uuid) {

        return restaurantService.getRestaurantById(uuid);

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantResponse> getRestaurants() {

        return restaurantService.getRestaurants();

    }

}
