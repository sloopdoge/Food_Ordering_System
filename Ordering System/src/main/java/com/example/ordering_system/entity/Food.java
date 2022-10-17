package com.example.ordering_system.entity;

import com.example.ordering_system.entity.enums.Cuisine;
import com.example.ordering_system.entity.enums.FoodType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "food")
public class Food {

    private static final String SEQ_NAME = "food_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "food_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FoodType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "cuisine")
    private Cuisine cuisine;

    @Column(name = "price")
    private Double price;

    public Food(String name, FoodType type, Cuisine cuisine, Double price) {
        this.name = name;
        this.type = type;
        this.cuisine = cuisine;
        this.price = price;
    }
}
