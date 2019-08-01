package com.example.demonytimes.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by: Ashwani Kumar
 * Date: 01-08-2019
 */
public class MediaMetadataTest {

    private MediaMetadata mediaMetadata;

    @Test
    public void testConstructor() {
        Assert.assertNull(mediaMetadata);
        mediaMetadata = new MediaMetadata();
        Assert.assertNotNull(mediaMetadata);
    }

    @Test
    public void testAttributes() {
        mediaMetadata = new MediaMetadata();

        mediaMetadata.setFormat("format");
        mediaMetadata.setUrl("url");
        mediaMetadata.setHeight("height");
        mediaMetadata.setWidth("width");

        Assert.assertNotNull(mediaMetadata.getFormat());
        Assert.assertNotNull(mediaMetadata.getUrl());
        Assert.assertNotNull(mediaMetadata.getHeight());
        Assert.assertNotNull(mediaMetadata.getWidth());

        Assert.assertEquals(mediaMetadata.getFormat(), "format");
        Assert.assertEquals(mediaMetadata.getUrl(), "url");
        Assert.assertEquals(mediaMetadata.getHeight(), "height");
        Assert.assertEquals(mediaMetadata.getWidth(), "width");

    }
}
