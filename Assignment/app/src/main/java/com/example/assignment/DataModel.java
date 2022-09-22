package com.example.assignment;

public class DataModel {
    int img;
    String category;
    int amount;
    String remarks;

    public DataModel(){

    }

    /*
    * img is the image used
    * category is the category of amount
    * amount is the amount is spent on it
    * */
    public DataModel(int img, String category, int amount){
        this.img = img;
        this.category = category;
        this.amount = amount;
    }
}
