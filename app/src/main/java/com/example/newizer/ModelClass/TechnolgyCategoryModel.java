package com.example.newizer.ModelClass;

public class TechnolgyCategoryModel {
    private int TecCatID;
    private String TecCatImageURL;
    private  String TecCatTitle;

    public TechnolgyCategoryModel(int tecCatID, String tecCatImageURL, String tecCatTitle) {
        TecCatID = tecCatID;
        TecCatImageURL = tecCatImageURL;
        TecCatTitle = tecCatTitle;
    }

    public int getTecCatID() {
        return TecCatID;
    }

    public void setTecCatID(int tecCatID) {
        TecCatID = tecCatID;
    }

    public String getTecCatImageURL() {
        return TecCatImageURL;
    }

    public void setTecCatImageURL(String tecCatImageURL) {
        TecCatImageURL = tecCatImageURL;
    }

    public String getTecCatTitle() {
        return TecCatTitle;
    }

    public void setTecCatTitle(String tecCatTitle) {
        TecCatTitle = tecCatTitle;
    }
}
