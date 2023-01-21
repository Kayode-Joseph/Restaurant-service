package com.kayode.restaurantservice.services.dish.utils;

import com.kayode.restaurantservice.entities.Dish;
import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.web.dtos.dish.DishRequest;
import com.kayode.restaurantservice.web.dtos.dish.DishResponse;

import java.util.UUID;

public class Util {

    public static Dish mapDishRequestToDish(DishRequest dishRequest, UUID dishPublicId, Restaurant restauant, String dishImageURL) {

        return Dish.builder().publicId(dishPublicId.toString()).dishName(dishRequest.getDishName())
                .description(dishRequest.getDescription()).hasImage(dishRequest.getDishPicture() != null)
                .photoURL(dishImageURL).restaurantId(restauant).isAvailable(true).build();
    }

    public static DishResponse mapDishToDishResponse(Dish dish) {

        return DishResponse.builder().dishName(dish.getDishName()).publicId(dish.getPublicId())
                .dishPhotoURL(dish.getPhotoURL()).description(dish.getDescription())
                .build();

    }
}
