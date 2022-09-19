package com.example.assignment;

public class DataModel {
    int img;
    String category, amount;

    /*
    * img is the image used
    * category is the category of amount
    * amount is the amount is spent on it
    * */
    public DataModel(int img, String category, String amount){
        this.img = img;
        this.category = category;
        this.amount =amount;
    }
}
