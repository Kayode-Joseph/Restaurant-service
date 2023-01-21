package com.kayode.restaurantservice.components.photoHandler.providers.localProviders;


import com.kayode.restaurantservice.components.photoHandler.providers.AbstractPhotoHandlerProvider;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public abstract class LocalPhotoHandlerProvider<T> extends AbstractPhotoHandlerProvider<T> {

    //set up application.properties to read dev properties
    @Value("${com.kayode.BASE_IMAGE_PATH}")
    private String hostName;

    public LocalPhotoHandlerProvider(Class<T> classProviderSupports) {
        super(classProviderSupports);
    }

    public String savePhotoInternal(String path, byte[] image){

        try (var logoByteArrayInStream = new ByteArrayInputStream(image)) {

            BufferedImage logoImage = ImageIO.read(logoByteArrayInStream);

            String logoPath = getClass().getClassLoader().getResource("static/images/")
                    .getFile() + path;

            File imageFile = new File(logoPath);

            imageFile.mkdir();

            ImageIO.write(logoImage, "png", imageFile);

        } catch (IOException e) {
           new RuntimeException(e);
        }

        return hostName+path;
    }



}






