package com.example.newizer.ModelClass;

public class NewsArticle {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public Source getSource() { return source; }
    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getUrl() { return url; }
    public String getUrlToImage() { return urlToImage; }
    public String getPublishedAt() { return publishedAt; }
    public String getContent() { return content; }

    // 👇 nested Source class matches JSON
    public static class Source {
        private String id;
        private String name;
        public String getId() { return id; }
        public String getName() { return name; }
    }
}
