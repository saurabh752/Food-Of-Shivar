package com.example.foodofshivar.adapter;

public class MyItemBuy {

    String buy_again_name;
    String buy_again_prise;
    String buy_again_btn;
    int buy_again_image;

    public MyItemBuy(String buy_again_name, String buy_again_prise, String buy_again_btn, int buy_again_image) {
        this.buy_again_name = buy_again_name;
        this.buy_again_prise = buy_again_prise;
        this.buy_again_btn = buy_again_btn;
        this.buy_again_image = buy_again_image;
    }

    public String getBuy_again_name() {
        return buy_again_name;
    }

    public void setBuy_again_name(String buy_again_name) {
        this.buy_again_name = buy_again_name;
    }

    public String getBuy_again_prise() {
        return buy_again_prise;
    }

    public void setBuy_again_prise(String buy_again_prise) {
        this.buy_again_prise = buy_again_prise;
    }

    public String getBuy_again_btn() {
        return buy_again_btn;
    }

    public void setBuy_again_btn(String buy_again_btn) {
        this.buy_again_btn = buy_again_btn;
    }

    public int getBuy_again_image() {
        return buy_again_image;
    }

    public void setBuy_again_image(int buy_again_image) {
        this.buy_again_image = buy_again_image;
    }
}
