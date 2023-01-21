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

    //come back to edit this query once authentication is set up
    @Query("""
    select r from Restaurant r where r.publicId=?1 and r.userId is null 
           """)
    Optional<Restaurant> getByIdAndUserId(String restaurantUUID, Integer userId);
}
