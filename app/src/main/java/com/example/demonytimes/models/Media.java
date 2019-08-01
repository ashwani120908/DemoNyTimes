package com.example.demonytimes.models;

import java.util.List;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */

public class Media {
    private String copyright;

    private List<MediaMetadata> mediaMetadata;

    private String subtype;

    private String caption;

    private String type;

    private String approved_for_syndication;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<MediaMetadata> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadata> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApprovedForSyndication() {
        return approved_for_syndication;
    }

    public void setApprovedForSyndication(String approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }
}


