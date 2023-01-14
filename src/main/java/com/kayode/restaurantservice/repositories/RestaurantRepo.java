package com.kayode.restaurantservice.repositories;

import com.kayode.restaurantservice.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

    @Query("""
    select r from Restaurant r where r.publicId=?1
           """)
    Optional<Restaurant> getById(UUID id);
}
