package com.example.foodofshivar.adapter;

public class MyItemNotification {
    String notification_textView;
    int notification_imageView;

    public MyItemNotification(String notification_textView, int notification_imageView) {
        this.notification_textView = notification_textView;
        this.notification_imageView = notification_imageView;
    }

    public String getNotification_textView() {
        return notification_textView;
    }

    public void setNotification_textView(String notification_textView) {
        this.notification_textView = notification_textView;
    }

    public int getNotification_imageView() {
        return notification_imageView;
    }

    public void setNotification_imageView(int notification_imageView) {
        this.notification_imageView = notification_imageView;
    }
}
