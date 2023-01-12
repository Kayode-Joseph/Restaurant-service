package com.kayode.restaurantservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    @Id
    private long dishId;

    private String dishName;

    private String publicId;

    private boolean hasImage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurantId;


}
