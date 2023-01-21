package com.kayode.restaurantservice.services.dish;

import com.kayode.restaurantservice.web.dtos.dish.DishRequest;
import com.kayode.restaurantservice.web.dtos.dish.DishResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface DishService {

    DishResponse createDish(DishRequest dishRequest, UUID restaurantUUID) throws IOException;

    DishResponse getDish(UUID restaurantId, UUID dishId);

    List<DishResponse> getDishesForARestaurant(UUID restaurantId);

}
