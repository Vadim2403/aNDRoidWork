package com.example.dream.galleryview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dream.R;
import com.example.dream.network.ImageRequester;
import com.example.dream.newsview.NewsCardViewHolder;
import com.example.dream.newsview.NewsModel;

import java.util.List;

public class GalleryCardRecyclerViewAdapter extends RecyclerView.Adapter<GalleryCardViewHolder>{
    private List<GalleryModel> galleryModelList;
    private ImageRequester imageRequester;

    public GalleryCardRecyclerViewAdapter(List<GalleryModel> galleryModelList) {
        this.galleryModelList = galleryModelList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public GalleryCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card, parent, false);
        return new GalleryCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryCardViewHolder holder, final int position) {
        if (galleryModelList != null && position < galleryModelList.size()) {
            GalleryModel gallery = galleryModelList.get(position);
            holder.gallery_title.setText(gallery.title);
            imageRequester.setImageFromUrl(holder.gallery_image, gallery.imageUrl);
        }
    }

    @Override
    public int getItemCount() {
        return galleryModelList.size();
    }
}
