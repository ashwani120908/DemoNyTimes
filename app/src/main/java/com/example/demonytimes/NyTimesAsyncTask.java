package com.example.demonytimes;

import android.os.AsyncTask;
import android.util.Log;

import com.example.demonytimes.models.NyTimesResponseModel;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */
class NyTimesAsyncTask extends AsyncTask<String, Void, Boolean> {

    private static final String API_KEY = "WmbEXsnaroozst9LjWM5sAaT5ZOvRdTt";
    private OnResponseListener onResponseListener;
    private NyTimesResponseModel nyTimesResponseModel;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(String... urls) {
        try {

            HttpGet httppost = new HttpGet("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key=" + API_KEY);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httppost);

            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);
                Log.e("NYTIMES-RESPONSE", data + " ");
                nyTimesResponseModel = new Gson().fromJson(data, NyTimesResponseModel.class);
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void onPostExecute(Boolean result) {
        if (result) {
            onResponseListener.onResponseSuccessful(nyTimesResponseModel);
        } else {
            onResponseListener.onResponseFailure();
        }
    }

    public void setOnResponseListener(OnResponseListener onResponseListener) {
        this.onResponseListener = onResponseListener;
    }
}
