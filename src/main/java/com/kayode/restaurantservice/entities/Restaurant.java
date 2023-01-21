package com.kayode.restaurantservice.entities;

import jakarta.persistence.*;
import lombok.*;
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

    @Column(unique = true)
    private String publicId;

    private Integer userId;

    private String logoURL;

   @OneToMany(mappedBy = "restaurantId")
   private List<Dish> dishes;


}
