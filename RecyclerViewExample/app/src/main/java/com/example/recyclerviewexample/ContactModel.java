package com.example.recyclerviewexample;
/*
* create a data type for array list
* */
public class ContactModel {
    int img;
    String name, number;

    /*
    * img is the image name of contact
    * name is name of contact
    * number is contact's phone number
    * */
    public ContactModel(int img, String name, String number){
        this.name = name;
        this.number = number;
        this.img = img;
    }
}
