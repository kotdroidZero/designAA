package com.error_found.kotdroid.designa;

/**
 * Created by user12 on 5/2/18.
 */

public class ModelStore {
    int image;
    double rating,size;
    String name,price;
    int position;

    public ModelStore(int image, String name, double size,double rating, String price, int position) {
        this.image = image;
        this.name = name;
        this.rating=rating;
        this.size = size;
        this.price = price;
        this.position = position;
    }
}
