package com.example.ordering_system.repository;

import com.example.ordering_system.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

}
