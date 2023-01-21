package com.kayode.restaurantservice.services.dish;

import com.kayode.restaurantservice.components.photoHandler.manager.PhotoHandlerManager;
import com.kayode.restaurantservice.entities.Dish;
import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.repositories.DishRepo;
import com.kayode.restaurantservice.services.restaurant.RestaurantService;
import com.kayode.restaurantservice.web.dtos.dish.DishRequest;
import com.kayode.restaurantservice.web.dtos.dish.DishResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.kayode.restaurantservice.services.dish.utils.Util.*;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepo dishRepo;

    private final RestaurantService restaurantService;

    private final PhotoHandlerManager photoHandlerManager;

    @Override
    public DishResponse createDish(DishRequest dishRequest, UUID restaurantUUID) throws IOException {

        //TODO:get user Id from context and use it to find restaurantId

        Optional<Restaurant> restaurantOptional = restaurantService
                .getRestaurantByPublicIdAndUserId(restaurantUUID, null);

        if (restaurantOptional.isEmpty()) {
            throw new AccessDeniedException("NOT AUTHORIZED TO ACCESS RESOURCE");
        }

        UUID dishPublicId = UUID.randomUUID();

        String dishPictureURL=null;

        if (dishRequest.getDishPicture() != null) {
             dishPictureURL = photoHandlerManager.savePhoto(DishService.class, dishPublicId, dishRequest.getDishPicture().getBytes());
        }

        Dish dish = dishRepo.save(mapDishRequestToDish(dishRequest, dishPublicId, restaurantOptional.get(), dishPictureURL));

        return mapDishToDishResponse(dish);

    }

    @Override
    public DishResponse getDish(UUID restaurantId, UUID dishId) {
        return null;
    }

    @Override
    public List<DishResponse> getDishesForARestaurant(UUID restaurantId) {
        return null;
    }
}
