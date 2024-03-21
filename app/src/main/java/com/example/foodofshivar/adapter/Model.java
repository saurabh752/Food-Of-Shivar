package com.example.foodofshivar.adapter;

public class Model {
    String name,price,image;

    Model(){

    }

    public Model(String name, String price, String image, int quantity, String cartItemId) {
        this.name = name;
        this.price = price;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
