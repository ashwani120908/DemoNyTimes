package com.example.demonytimes.models;

import java.util.List;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */

public class NyTimesResponseModel {
    private String copyright;

    private List<Results> results;

    private String num_results;

    private String status;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getNumResults() {
        return num_results;
    }

    public void setNumRresults(String num_results) {
        this.num_results = num_results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

