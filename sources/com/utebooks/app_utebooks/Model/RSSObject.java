package com.utebooks.app_utebooks.Model;

import java.util.List;

public class RSSObject {
    public Feed feed;
    public List<Item> items;
    public String status;

    public RSSObject(String status2, Feed feed2, List<Item> items2) {
        this.status = status2;
        this.feed = feed2;
        this.items = items2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public Feed getFeed() {
        return this.feed;
    }

    public void setFeed(Feed feed2) {
        this.feed = feed2;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items2) {
        this.items = items2;
    }
}
