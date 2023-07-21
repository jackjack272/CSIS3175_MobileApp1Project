package com.example.appdevfinalprojct2.Dish;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
public class Dish_Instruction {

    private Integer step_number;
    private String step_instruction;


    public Dish_Instruction(Integer step_number, String step_instruction) {
        this.step_number = step_number;
        this.step_instruction = step_instruction;
    }

    public Integer getStep_number() {
        return step_number;
    }

    public String getStep_instruction() {
        return step_instruction;
    }



}




