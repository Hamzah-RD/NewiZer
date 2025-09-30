package com.example.newizer.ModelClass;

public class TrendingModel {
private  int id;
private String trendingCategory;
private String trendingTitle;
private String trendingImageURL;
private String trendingDate;
private String trendingContent;
private String trendingUrl;

    public String getTrendingContent() {
        return trendingContent;
    }

    public TrendingModel(int id, String trendingCategory, String trendingTitle, String trendingImageURL,
                         String trendingDate, String trendingContent, String trendingUrl) {
        this.id = id;
        this.trendingCategory = trendingCategory;
        this.trendingTitle = trendingTitle;
        this.trendingImageURL = trendingImageURL;
        this.trendingDate = trendingDate;
        this.trendingContent = trendingContent;
        this.trendingUrl = trendingUrl;
    }

    public void setTrendingContent(String trendingContent) {
        this.trendingContent = trendingContent;
    }

    public String getTrendingUrl() {
        return trendingUrl;
    }

    public void setTrendingUrl(String trendingUrl) {
        this.trendingUrl = trendingUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrendingCategory() {
        return trendingCategory;
    }

    public void setTrendingCategory(String trendingCategory) {
        this.trendingCategory = trendingCategory;
    }

    public String getTrendingTitle() {
        return trendingTitle;
    }

    public void setTrendingTitle(String trendingTitle) {
        this.trendingTitle = trendingTitle;
    }

    public String getTrendingImageURL() {
        return trendingImageURL;
    }

    public void setTrendingImageURL(String trendingImageURL) {
        this.trendingImageURL = trendingImageURL;
    }

    public String getTrendingDate() {
        return trendingDate;
    }

    public void setTrendingDate(String trendingDate) {
        this.trendingDate = trendingDate;
    }


}
