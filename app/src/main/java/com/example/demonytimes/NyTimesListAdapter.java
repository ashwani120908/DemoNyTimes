package com.example.demonytimes;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demonytimes.models.NyTimesResponseModel;
import com.example.demonytimes.models.Results;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */

public class NyTimesListAdapter extends RecyclerView.Adapter<NyTimesListAdapter.ViewHolder> {
    private NyTimesResponseModel listdata;
    NyTimesMostPopularViewModel viewModel;

    public NyTimesListAdapter(NyTimesResponseModel listdata, NyTimesMostPopularViewModel viewModel) {
        this.listdata = listdata;
        this.viewModel = viewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Results results = listdata.getResults().get(position);
        holder.titleTv.setText(results.getTitle());
        holder.abstractTitleTv.setText(results.getAbstract());
        holder.dateTv.setText(results.getPublishedDate());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 viewModel.onItemClicked(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.getResults().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView postIv;
        private TextView titleTv, abstractTitleTv, dateTv;
        private ConstraintLayout constraintLayout;

        private ViewHolder(View itemView) {
            super(itemView);
            this.postIv = (ImageView) itemView.findViewById(R.id.postIv);
            this.titleTv = (TextView) itemView.findViewById(R.id.titleTv);
            this.abstractTitleTv = (TextView) itemView.findViewById(R.id.abstractTitleTv);
            this.dateTv = (TextView) itemView.findViewById(R.id.dateTv);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.parentLayout);
        }
    }
}
