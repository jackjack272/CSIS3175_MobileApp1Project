package com.example.appdevfinalprojct2;

import android.util.Log;

import org.json.JSONObject;

public class Dish {

    private Integer id;
    private String title;
    private String image;
    private double calories;


    private String sourceUrl;
    private String summary;
    private String insuructions;


    public Dish(int id, String title, String image, double calories) {
    }

    public Integer getId() {
        return id;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public double getCalories() {
        return calories;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getSummary() {
        return summary;
    }

    public String getInsuructions() {
        return insuructions;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setInsuructions(String insuructions) {
        this.insuructions = insuructions;
    }


    //make sure to have https not http
        // might not work otherwise



}

