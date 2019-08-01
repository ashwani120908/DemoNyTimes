package com.example.demonytimes.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by: Ashwani Kumar
 * Email: ashwani.banodha@nagarro.com
 * Date: 31-07-2019
 */

public class Results {

    @SerializedName("abstract")
    private String abstractText;

    private List<Media> media;

    private String title;

    private String url;

    private String id;

    private String published_date;

    private String views;

    public String getAbstract() {
        return abstractText;
    }

    public void setAbstract(String abstractText) {
        this.abstractText = abstractText;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublishedDate() {
        return published_date;
    }

    public void setPublishedDate(String published_date) {
        this.published_date = published_date;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}

