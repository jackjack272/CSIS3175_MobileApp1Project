package com.example.appdevfinalprojct2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
public class Dish_Ingredient {
    private String name;
    private String unit;
    private Double amount;


    public Dish_Ingredient(String name, String unit, Double amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Double getAmount() {
        return amount;
    }
}
