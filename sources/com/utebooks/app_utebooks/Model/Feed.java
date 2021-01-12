package com.utebooks.app_utebooks.Model;

public class Feed {
    public String author;
    public String description;
    public String image;
    public String link;
    public String title;
    public String url;

    public Feed(String url2, String title2, String link2, String author2, String description2, String image2) {
        this.url = url2;
        this.title = title2;
        this.link = link2;
        this.author = author2;
        this.description = description2;
        this.image = image2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link2) {
        this.link = link2;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author2) {
        this.author = author2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image2) {
        this.image = image2;
    }
}
