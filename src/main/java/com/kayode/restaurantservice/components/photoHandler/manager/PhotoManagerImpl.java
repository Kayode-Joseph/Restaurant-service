package com.kayode.restaurantservice.components.photoHandler.manager;

import com.kayode.restaurantservice.components.photoHandler.providers.PhotoHandlerProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PhotoManagerImpl implements PhotoHandlerManager{


    private final List<PhotoHandlerProvider> providers;

    @Override
    public String savePhoto(Class requestingClass, UUID fileName, byte[] photo) {

     PhotoHandlerProvider provider= providers.stream().filter((providers)->providers.supports(requestingClass))
                .findFirst().orElseThrow(()->new RuntimeException("No Hander found"));

    return provider.savePhoto(fileName,photo);

    }

}
