package com.kayode.restaurantservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dishId;

    @Column(unique = true)
    private String publicId;

    private String dishName;

    @Column(columnDefinition="TEXT")
    private String description;

    private boolean hasImage;

    private String photoURL;

    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurantId;


}
