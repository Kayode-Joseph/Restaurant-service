package com.kayode.restaurantservice.services.restaurant;

import com.kayode.restaurantservice.Exceptions.NoRecordFoundException;
import com.kayode.restaurantservice.entities.Restaurant;
import com.kayode.restaurantservice.repositories.RestaurantRepo;
import com.kayode.restaurantservice.services.restaurant.RestaurantService;
import com.kayode.restaurantservice.web.dtos.RestaurantRequest;
import com.kayode.restaurantservice.web.dtos.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) throws IOException {

        UUID uuid = UUID.randomUUID();

        handleRestaurantLogoCreation(restaurantRequest.getRestaurantLogo().getBytes(), uuid);

        Restaurant restaurant = restaurantRepo.save(Restaurant.builder().address(restaurantRequest.getAddress())
                .latitude(restaurantRequest.getLatitude()).longitude(restaurantRequest.getLongitude())
                .name(restaurantRequest.getName()).publicId(uuid).build());

        return mapRestaurantToRestaurantResponse(restaurant);

    }

    @Override
    public RestaurantResponse getRestaurantById(UUID uuid) {

        Optional<Restaurant> restaurantOptional = restaurantRepo.getById(uuid);

        Restaurant restaurant = restaurantOptional.orElseThrow(NoRecordFoundException::new);

        return mapRestaurantToRestaurantResponse(restaurant);

    }

    @Override
    public List<RestaurantResponse> getRestaurants() {

        List<Restaurant> restaurants = restaurantRepo.findAll();

        return restaurants.stream().map(this::mapRestaurantToRestaurantResponse).collect(Collectors.toList());

    }

    @Override
    public void saveRestaurantLogo() {

    }

    private RestaurantResponse mapRestaurantToRestaurantResponse(Restaurant restaurant) {

        return RestaurantResponse.builder().name(restaurant.getName()).publicId(restaurant.getPublicId())
                .latitude(restaurant.getLatitude()).longitude(restaurant.getLongitude()).address(restaurant.getAddress())
                .build();

    }

    private void handleRestaurantLogoCreation(byte[] logo, UUID photoName) {

        try (var logoByteArrayInStream = new ByteArrayInputStream(logo)) {

            BufferedImage logoImage = ImageIO.read(logoByteArrayInStream);

            String logoPath = getClass().getClassLoader().getResource("static/images/")
                    .getFile() + photoName + ".png";

            File imageFile = new File(logoPath);

            imageFile.mkdir();

            ImageIO.write(logoImage, "png", imageFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
