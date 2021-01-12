package com.utebooks.app_utebooks.Model;

import java.util.List;

public class Item {
    public String author;
    public List<String> categories;
    public String content;
    public String description;
    public Object enclosure;
    public String guid;
    public String link;
    public String pubDate;
    public String thumbnail;
    public String title;

    public Item(String title2, String pubDate2, String link2, String guid2, String author2, String thumbnail2, String description2, String content2, Object enclosure2, List<String> categories2) {
        this.title = title2;
        this.pubDate = pubDate2;
        this.link = link2;
        this.guid = guid2;
        this.author = author2;
        this.thumbnail = thumbnail2;
        this.description = description2;
        this.content = content2;
        this.enclosure = enclosure2;
        this.categories = categories2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(String pubDate2) {
        this.pubDate = pubDate2;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link2) {
        this.link = link2;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid2) {
        this.guid = guid2;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author2) {
        this.author = author2;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public Object getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(Object enclosure2) {
        this.enclosure = enclosure2;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories2) {
        this.categories = categories2;
    }
}
