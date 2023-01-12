package com.kayode.restaurantservice.repositories;

import com.kayode.restaurantservice.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {


}
