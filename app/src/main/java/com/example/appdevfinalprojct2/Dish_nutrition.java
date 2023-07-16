package com.example.appdevfinalprojct2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter

//it dosent work >:(
public class Dish_nutrition {
    private Double calories;
    private Double fat;
    private Double saturated_fat;
    private Double carbs;
    private Double sugar;
    private Double sodium;
    private Double protine;
    private Double fiber;


    public Dish_nutrition(Double calories, Double fat, Double saturated_fat, Double carbs, Double sugar, Double sodium, Double protine, Double fiber) {
        this.calories = calories;
        this.fat = fat;
        this.saturated_fat = saturated_fat;
        this.carbs = carbs;
        this.sugar = sugar;
        this.sodium = sodium;
        this.protine = protine;
        this.fiber = fiber;
    }


    public Double getCalories() {
        return calories;
    }

    public Double getFat() {
        return fat;
    }

    public Double getSaturated_fat() {
        return saturated_fat;
    }

    public Double getCarbs() {
        return carbs;
    }

    public Double getSugar() {
        return sugar;
    }

    public Double getSodium() {
        return sodium;
    }

    public Double getProtine() {
        return protine;
    }

    public Double getFiber() {
        return fiber;
    }
}
