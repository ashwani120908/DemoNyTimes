package com.example.demonytimes.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by: Ashwani Kumar
 * Date: 01-08-2019
 */
public class NyTimesResponseModelTest {

    private NyTimesResponseModel nyTimesResponseModel;

    @Test
    public void testConstructor() {
        Assert.assertNull(nyTimesResponseModel);
        nyTimesResponseModel = new NyTimesResponseModel();
        Assert.assertNotNull(nyTimesResponseModel);
    }

    @Test
    public void testAttributes() {
        nyTimesResponseModel = new NyTimesResponseModel();

        nyTimesResponseModel.setStatus("200");
        nyTimesResponseModel.setCopyright("copyright");
        nyTimesResponseModel.setNumRresults("20");
        nyTimesResponseModel.setResults(new ArrayList<Results>());

        Assert.assertNotNull(nyTimesResponseModel.getStatus());
        Assert.assertNotNull(nyTimesResponseModel.getCopyright());
        Assert.assertNotNull(nyTimesResponseModel.getNumResults());

        Assert.assertEquals(nyTimesResponseModel.getStatus(),"200");
        Assert.assertEquals(nyTimesResponseModel.getCopyright(),"copyright");
        Assert.assertEquals(nyTimesResponseModel.getNumResults(),"20");
    }
}
