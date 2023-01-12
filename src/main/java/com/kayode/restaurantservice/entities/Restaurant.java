package com.kayode.restaurantservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantId;

    private String name;

    private double latitude;

    private double longitude;

    private String address;

    private UUID publicId;

    private int userId;

   @OneToMany(mappedBy = "restaurantId")
   private List<Dish> dishes;


}