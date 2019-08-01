package com.example.demonytimes;

import com.example.demonytimes.models.NyTimesResponseModel;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */
public interface OnResponseListener {

    void onResponseSuccessful(NyTimesResponseModel response);

    void onResponseFailure();
}
