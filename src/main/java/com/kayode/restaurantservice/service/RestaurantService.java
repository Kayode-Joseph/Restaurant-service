package com.kayode.restaurantservice.service;

import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.repositories.RestaurantRepo;
import com.kayode.restaurantservice.web.dtos.CreateRestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public String createRestaurant(CreateRestaurantRequest createRestaurantRequest){

        restaurantRepo.save(Restaurant.builder().address(createRestaurantRequest.getAddress())
                .latitude(createRestaurantRequest.getLatitude()).longitude(createRestaurantRequest.getLongitude())
                .name(createRestaurantRequest.getName()).publicId(UUID.randomUUID()).build());

        return "SUCCESS";



    }


}
