package com.kayode.restaurantservice.services.restaurant;

import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) throws IOException;

    RestaurantResponse getRestaurantById(UUID uuid);

    List<RestaurantResponse> getRestaurants();

    Optional<Restaurant> getRestaurantByPublicIdAndUserId(UUID restaurantId, Integer userId);

}
