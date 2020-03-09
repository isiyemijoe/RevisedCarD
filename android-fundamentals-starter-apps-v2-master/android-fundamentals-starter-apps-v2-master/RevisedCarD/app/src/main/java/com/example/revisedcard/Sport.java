package com.example.revisedcard;

public class Sport {
    private final int imageResource;
    String Title;
    String Info;

    public Sport(String title, String info, int imageResource) {
        Title = title;
        Info = info;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
