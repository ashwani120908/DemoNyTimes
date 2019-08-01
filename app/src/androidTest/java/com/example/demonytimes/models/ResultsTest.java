package com.example.demonytimes.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by: Ashwani Kumar
 * Date: 01-08-2019
 */
public class ResultsTest {

    private Results results;

    @Test
    public void testConstructor() {
        Assert.assertNull(results);
        results = new Results();
        Assert.assertNotNull(results);
    }

    @Test
    public void testAttributes() {
        results = new Results();

        results.setId("id");
        results.setTitle("title");
        results.setAbstract("abstract");
        results.setMedia(new ArrayList<Media>());
        results.setPublishedDate("date");
        results.setUrl("url");
        results.setViews("views");

        Assert.assertNotNull(results.getId());
        Assert.assertNotNull(results.getTitle());
        Assert.assertNotNull(results.getAbstract());
        Assert.assertNotNull(results.getMedia());
        Assert.assertNotNull(results.getPublishedDate());
        Assert.assertNotNull(results.getUrl());
        Assert.assertNotNull(results.getViews());

        Assert.assertEquals(results.getId(), "id");
        Assert.assertEquals(results.getTitle(), "title");
        Assert.assertEquals(results.getAbstract(), "abstract");
        Assert.assertEquals(results.getPublishedDate(), "date");
        Assert.assertEquals(results.getUrl(), "url");
        Assert.assertEquals(results.getViews(), "views");

    }
}
