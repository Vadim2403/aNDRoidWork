package com.example.dream.newsview;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.dream.R;

public class NewsCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView news_image;
    public TextView news_title;
    private View view;
    public NewsCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        news_image = itemView.findViewById(R.id.news_image);
        news_title = itemView.findViewById(R.id.news_title);
    }

    public View getView() {
        return view;
    }
}
