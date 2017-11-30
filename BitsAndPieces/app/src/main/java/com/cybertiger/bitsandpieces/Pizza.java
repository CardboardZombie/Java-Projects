package com.cybertiger.bitsandpieces;

/**
 * Created by tdm on 30/05/2017.
 * In a real app, this Data would be stored in a Database [Java class is just for simplicity]
 */

public class Pizza {
    private String name;
    private int imageResourceId;

    public static final Pizza[] pizzas = {
            new Pizza("Dalek Wallpaper", R.drawable.dalek),
            new Pizza("Low Poly Model Collection", R.drawable.evoke)
    };

    private Pizza(String name, int imageResourceId){
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName(){
        return name;
    }
    public int getImgId(){
        return imageResourceId;
    }
}
