package com.example.demonytimes;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.demonytimes.models.NyTimesResponseModel;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */
public class NyTimesMostPopularActivity extends NyTimesMostPopularViewModel {

    private NyTimesMostPopularViewModel viewModel;
    private NyTimesResponseModel responseModel;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new NyTimesMostPopularViewModel();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        registerListeners();
        if (isNetworkConnected()) {
            showLoader();
            viewModel.getNyTimesMostPopularList();
        } else {
            showErrorDialog(R.string.network_error);
        }
    }

    private void registerListeners() {
        viewModel.responseLiveData.observe(this, new Observer<NyTimesResponseModel>() {
            @Override
            public void onChanged(@Nullable NyTimesResponseModel responseModel) {
                if (responseModel != null) {
                    setupRecyclerView(responseModel);
                } else {
                    hideLoader();
                    showErrorDialog(R.string.server_error);
                }
            }
        });
        viewModel.itemClicked.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer position) {
                openClickedItem(position);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.responseLiveData.removeObservers(this);
        viewModel.itemClicked.removeObservers(this);
    }

    private void openClickedItem(Integer position) {
        Intent intent = new Intent(this, NyTimesDetailViewActivity.class);
        intent.putExtra(NyTimesDetailViewActivity.POST_URL_KEY, responseModel.getResults().get(position).getUrl());
        startActivity(intent);
    }

    private void setupRecyclerView(NyTimesResponseModel responseModel) {
        hideLoader();
        this.responseModel = responseModel;
        NyTimesListAdapter adapter = new NyTimesListAdapter(responseModel, viewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    protected void showLoader() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(NyTimesMostPopularActivity.this);
            progressDialog.setMessage(getApplicationContext().getString(R.string.please_wait));
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    protected void hideLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void showErrorDialog(int message) {
        alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.error)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
