package com.example.demonytimes;

import android.arch.lifecycle.MutableLiveData;
import android.support.v7.app.AppCompatActivity;

import com.example.demonytimes.models.NyTimesResponseModel;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */
public class NyTimesMostPopularViewModel extends AppCompatActivity implements OnResponseListener {

    public final MutableLiveData<NyTimesResponseModel> responseLiveData = new MutableLiveData<>();
    public final MutableLiveData<Integer> itemClicked = new MutableLiveData<>();

    protected void getNyTimesMostPopularList() {
        NyTimesAsyncTask nyTimesAsyncTask = new NyTimesAsyncTask();
        nyTimesAsyncTask.setOnResponseListener(this);
        nyTimesAsyncTask.execute();
    }

    @Override
    public void onResponseSuccessful(NyTimesResponseModel response) {
        responseLiveData.setValue(response);
    }

    @Override
    public void onResponseFailure() {
        responseLiveData.setValue(null);
    }

    public void onItemClicked(int position) {
        itemClicked.setValue(position);
    }
}
