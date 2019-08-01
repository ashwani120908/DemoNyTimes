package com.example.demonytimes.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by: Ashwani Kumar
 * Date: 01-08-2019
 */
public class MediaTest {
    private Media media;

    @Test
    public void testConstructor() {
        Assert.assertNull(media);
        media = new Media();
        Assert.assertNotNull(media);
    }

    @Test
    public void testAttributes() {
        media = new Media();
        media.setApprovedForSyndication("ApprovedForSyndication");
        media.setCaption("Caption");
        media.setCopyright("Copyright");
        media.setType("Post");
        media.setMediaMetadata(new ArrayList<MediaMetadata>());


        Assert.assertNotNull(media.getApprovedForSyndication());
        Assert.assertNotNull(media.getCaption());
        Assert.assertNotNull(media.getCopyright());
        Assert.assertNotNull(media.getType());
        Assert.assertNotNull(media.getMediaMetadata());

        Assert.assertEquals(media.getApprovedForSyndication(),"ApprovedForSyndication");
        Assert.assertEquals(media.getCaption(),"Caption");
        Assert.assertEquals(media.getCopyright(),"Copyright");
        Assert.assertEquals(media.getType(),"Post");
    }
}
