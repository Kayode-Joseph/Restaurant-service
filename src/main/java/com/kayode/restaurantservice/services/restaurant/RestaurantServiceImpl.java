package com.kayode.restaurantservice.services.restaurant;

import com.kayode.restaurantservice.components.photoHandler.manager.PhotoHandlerManager;
import com.kayode.restaurantservice.exceptions.NoRecordFoundException;
import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.repositories.RestaurantRepo;
import com.kayode.restaurantservice.services.restaurant.utils.Util;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.restaurant.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.kayode.restaurantservice.services.restaurant.utils.Util.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;

    private final PhotoHandlerManager photoHandlerManager;

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) throws IOException {

        UUID uuid = UUID.randomUUID();

       String restaurantLogoURL= photoHandlerManager.savePhoto(RestaurantService.class, uuid
               , restaurantRequest.getRestaurantLogo().getBytes());

        Restaurant restaurant = restaurantRepo
                .save(mapRestaurantRequestToRestaurant(restaurantRequest,restaurantLogoURL,uuid));

        return mapRestaurantToRestaurantResponse(restaurant);

    }

    @Override
    public RestaurantResponse getRestaurantById(UUID uuid) {

        Optional<Restaurant> restaurantOptional = restaurantRepo.getById(uuid);

        Restaurant restaurant = restaurantOptional.orElseThrow(NoRecordFoundException::new);

        return mapRestaurantToRestaurantResponse(restaurant);

    }

    @Override
    public List<RestaurantResponse> getRestaurants() {

        List<Restaurant> restaurants = restaurantRepo.findAll();

        return restaurants.stream().map(Util::mapRestaurantToRestaurantResponse).collect(Collectors.toList());

    }

    @Override
    public Optional<Restaurant> getRestaurantByPublicIdAndUserId(UUID restaurantId, Integer userId) {
        Optional<Restaurant> restaurantOptional= restaurantRepo.getByIdAndUserId(restaurantId.toString(), userId);
        return restaurantOptional;
    }










}
