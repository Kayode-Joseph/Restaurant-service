package com.kayode.restaurantservice.repositories;

import com.kayode.restaurantservice.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepo extends JpaRepository<Dish,Long > {



}
