package com.kayode.restaurantservice.services.restaurant;

import com.kayode.restaurantservice.web.dtos.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.RestaurantResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface RestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) throws IOException;

    RestaurantResponse getRestaurantById(UUID uuid);

    List<RestaurantResponse> getRestaurants();

    void saveRestaurantLogo();
}
