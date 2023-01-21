package com.kayode.restaurantservice.components.photoHandler.providers.localProviders.restaurant;

import com.kayode.restaurantservice.components.photoHandler.providers.localProviders.LocalPhotoHandlerProvider;
import com.kayode.restaurantservice.services.restaurant.RestaurantService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class RestaurantServiceLocalPhotoHandlerProvider extends LocalPhotoHandlerProvider<RestaurantService> {

    private static final String BASE_PATH= "restaurant/";

    private static final String DEFAULT_IMAGE_SUFFIX=".png";

    public RestaurantServiceLocalPhotoHandlerProvider() {
        super(RestaurantService.class);
    }

    @Override
    public String savePhoto(UUID fileName, byte[] image) {
       return super.savePhotoInternal(BASE_PATH+fileName+DEFAULT_IMAGE_SUFFIX, image);
    }


}
