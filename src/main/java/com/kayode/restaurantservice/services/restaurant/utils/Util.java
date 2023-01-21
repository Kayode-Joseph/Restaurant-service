package com.kayode.restaurantservice.services.restaurant.utils;

import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantResponse;

import java.util.UUID;

public class Util {

    public static Restaurant mapRestaurantRequestToRestaurant(RestaurantRequest restaurantRequest
            , String imageURL, UUID uuid) {
        return Restaurant.builder().address(restaurantRequest.getAddress())
                .latitude(restaurantRequest.getLatitude()).longitude(restaurantRequest.getLongitude())
                .name(restaurantRequest.getName()).logoURL(imageURL).publicId(uuid.toString()).build();

    }

    public static RestaurantResponse mapRestaurantToRestaurantResponse(Restaurant restaurant) {

        return RestaurantResponse.builder().name(restaurant.getName()).publicId(UUID.fromString(restaurant.getPublicId()))
                .latitude(restaurant.getLatitude()).longitude(restaurant.getLongitude()).address(restaurant.getAddress())
                .logoURL(restaurant.getLogoURL()).build();

    }

}
