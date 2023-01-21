package com.kayode.restaurantservice.web.controllers.restaurant;


import com.kayode.restaurantservice.services.restaurant.RestaurantService;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse createRestaurant(@Valid @ModelAttribute @NonNull RestaurantRequest restaurantRequest) throws IOException, URISyntaxException {

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
