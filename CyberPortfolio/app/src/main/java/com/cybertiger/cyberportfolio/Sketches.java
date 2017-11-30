package com.cybertiger.cyberportfolio;

/**
 * Created by Tadhg Deeney on 03/05/2017.
 */

public class Sketches {
    private String name;
    private String description;
    private int imageResourceID;

    //sketches is an Array of com.cybertiger.cyberportfolio.Sketches
    /*public static final Sketches[] sktch = {
            new Sketches("Chameleon", "Something I saw Brona draw once",
                    R.drawable.chameleon),
            new Sketches("Owls", "Playing around with color in PhotoShop",
                    R.drawable.owls),
            new Sketches("Big Friendly Elephants", "Flat Elephant Design",
                    R.drawable.elephants)
    };*/

    private Sketches(String name, String description, int imageResourceID){
        this.name = name;
        this.description = description;
        this.imageResourceID = imageResourceID;
    }
    public String getDesc(){
        return description;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageResourceID;
    }
    public String toString(){
        return this.name;
    }
}
