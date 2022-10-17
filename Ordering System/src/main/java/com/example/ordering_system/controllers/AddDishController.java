package com.example.ordering_system.controllers;

import com.example.ordering_system.entity.Drink;
import com.example.ordering_system.entity.Food;
import com.example.ordering_system.entity.enums.Cuisine;
import com.example.ordering_system.entity.enums.FoodType;
import com.example.ordering_system.repository.DrinkRepository;
import com.example.ordering_system.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddDishController {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping("/add_dish")
    public String addDishes(Model model) {
        model.addAttribute("title", "Add dishes");
        return "add_dish";
    }

    @PostMapping("/add_food")
    public String addFood(@RequestParam(name = "name") String name,
                          @RequestParam(name = "type") FoodType foodType,
                          @RequestParam(name = "cuisine") Cuisine cuisine,
                          @RequestParam(name = "price") Double price) {
        Food newFood = new Food(name, foodType, cuisine, price);
        foodRepository.save(newFood);
        return "redirect:/add_dish";
    }

    @PostMapping("/add_drink")
    public String addDrink(@RequestParam(name = "name") String name,
                          @RequestParam(name = "price") Double price) {
        Drink newDrink = new Drink(name, price);
        drinkRepository.save(newDrink);
        return "redirect:/add_dish";
    }
}
