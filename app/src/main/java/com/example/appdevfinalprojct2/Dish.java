package com.example.appdevfinalprojct2;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
public class Dish {

    List<Dish_Instruction> dish_instruction_list;

    List<Dish_Ingredient> dish_ingredients;
    Dish_nutrition dish_nutritions;

    private Long id;
    private String title;
    private Double calories;
    private Boolean vegetarian;
    private Double serving_size;
    private String summary;
    private String dish_image;
    //make sure to have https not http
        // might not work otherwise




    public Dish(List<Dish_Instruction> dish_instruction_list, List<Dish_Ingredient> dish_ingredients, Dish_nutrition dish_nutritions, Long id, String title, Double calories, Boolean vegetarian, Double serving_size, String summary, String dish_image) {
        this.dish_instruction_list = dish_instruction_list;
        this.dish_ingredients = dish_ingredients;
        this.dish_nutritions = dish_nutritions;
        this.id = id;
        this.title = title;
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.serving_size = serving_size;
        this.summary = summary;
        this.dish_image = dish_image;
    }

    public List<Dish_Instruction> getDish_instruction_list() {
        return dish_instruction_list;
    }

    public List<Dish_Ingredient> getDish_ingredients() {
        return dish_ingredients;
    }

    public Dish_nutrition getDish_nutritions() {
        return dish_nutritions;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getCalories() {
        return calories;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public Double getServing_size() {
        return serving_size;
    }

    public String getSummary() {
        return summary;
    }

    public String getDish_image() {
        return dish_image;
    }
}

