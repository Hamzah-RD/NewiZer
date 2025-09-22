package com.example.newizer.ModelClass;

public class SliderModel {
   private int  sliderId;
   private String imageURL;

    public SliderModel(int sliderId, String imageURL) {
        this.sliderId = sliderId;
        this.imageURL = imageURL;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
