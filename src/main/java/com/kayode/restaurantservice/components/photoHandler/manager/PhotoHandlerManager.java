package com.kayode.restaurantservice.components.photoHandler.manager;

import java.util.UUID;

public interface PhotoHandlerManager {

    public String savePhoto(Class requestingClass, UUID fileName, byte[] photo);
}
