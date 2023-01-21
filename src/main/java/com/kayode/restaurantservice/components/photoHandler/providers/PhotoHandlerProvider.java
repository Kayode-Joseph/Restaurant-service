package com.kayode.restaurantservice.components.photoHandler.providers;

import java.util.UUID;

public interface PhotoHandlerProvider {

     String savePhoto(UUID fileName, byte[] photo);

      boolean supports(Class clazz);


}
