package com.example.newizer.ModelClass;

public class CategoryModel {
    private int Categoryid;
    private String Categoryname;

    public CategoryModel(int categoryid, String categoryname, String imageurl) {
        Categoryid = categoryid;
        Categoryname = categoryname;
        this.imageurl = imageurl;
    }

    private  String imageurl;

    public int getCategoryid() {
        return Categoryid;
    }

    public void setCategoryid(int categoryid) {
        Categoryid = categoryid;
    }

    public String getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(String categoryname) {
        Categoryname = categoryname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
