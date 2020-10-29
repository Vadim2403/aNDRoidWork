package com.example.dream.newsview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dream.network.ImageRequester;

import java.util.List;
import com.example.dream.R;

public class NewsCardRecyclerViewAdapter extends RecyclerView.Adapter<NewsCardViewHolder> {

    private List<NewsModel> newsList;
    private ImageRequester imageRequester;

    public NewsCardRecyclerViewAdapter(List<NewsModel> newsList) {
        this.newsList = newsList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public NewsCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new NewsCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCardViewHolder holder, final int position) {
        if (newsList != null && position < newsList.size()) {
            NewsModel news = newsList.get(position);
            holder.news_title.setText(news.title);
            imageRequester.setImageFromUrl(holder.news_image, news.imageUrl);
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
