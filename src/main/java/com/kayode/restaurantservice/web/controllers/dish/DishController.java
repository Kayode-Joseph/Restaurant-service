package com.kayode.restaurantservice.web.controllers.dish;


import com.kayode.restaurantservice.services.dish.DishService;
import com.kayode.restaurantservice.web.dtos.dish.DishRequest;
import com.kayode.restaurantservice.web.dtos.dish.DishResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class DishController {

    private final DishService dishService;

    @PostMapping (value="/{restaurant_id}/dish/register",  consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public DishResponse createDish(@ModelAttribute @Valid DishRequest dishRequest,
                                   @PathVariable("restaurant_id")UUID restaurant_id) throws IOException {

        return dishService.createDish(dishRequest, restaurant_id);

    }


}
