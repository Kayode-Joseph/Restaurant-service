package com.kayode.restaurantservice.components.photoHandler.providers.localProviders.dish;

import com.kayode.restaurantservice.components.photoHandler.providers.localProviders.LocalPhotoHandlerProvider;
import com.kayode.restaurantservice.services.dish.DishService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class DishServiceLocalPhotoHandlerProvider extends LocalPhotoHandlerProvider<DishService> {

    private static final String BASE_PATH= "dish/";

    private static final String DEFAULT_IMAGE_SUFFIX=".png";

    public DishServiceLocalPhotoHandlerProvider() {
        super(DishService.class);
    }

    @Override
    public String savePhoto(UUID fileName, byte[] photo) {
        return super.savePhotoInternal(BASE_PATH+fileName+DEFAULT_IMAGE_SUFFIX,photo);
    }
}
