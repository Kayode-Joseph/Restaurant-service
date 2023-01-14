package com.kayode.restaurantservice.services;

import com.kayode.restaurantservice.Exceptions.NoRecordFoundException;
import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.repositories.RestaurantRepo;
import com.kayode.restaurantservice.web.dtos.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {

        Restaurant restaurant = restaurantRepo.save(Restaurant.builder().address(restaurantRequest.getAddress())
                .latitude(restaurantRequest.getLatitude()).longitude(restaurantRequest.getLongitude())
                .name(restaurantRequest.getName()).publicId(UUID.randomUUID()).build());

        return mapRestaurantToRestaurantResponse(restaurant);

    }

    public RestaurantResponse getRestaurantById(UUID uuid) {

        Optional<Restaurant> restaurantOptional = restaurantRepo.getById(uuid);

        Restaurant restaurant = restaurantOptional.orElseThrow(NoRecordFoundException::new);

        return mapRestaurantToRestaurantResponse(restaurant);

    }

    public List<RestaurantResponse> getRestaurants() {

        List<Restaurant> restaurants = restaurantRepo.findAll();

        return restaurants.stream().map(this::mapRestaurantToRestaurantResponse).collect(Collectors.toList());

    }

    private RestaurantResponse mapRestaurantToRestaurantResponse(Restaurant restaurant) {

        return RestaurantResponse.builder().name(restaurant.getName()).publicId(restaurant.getPublicId())
                .latitude(restaurant.getLatitude()).longitude(restaurant.getLongitude()).address(restaurant.getAddress())
                .build();

    }


}
