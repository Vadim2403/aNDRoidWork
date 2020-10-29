package com.example.dream.galleryview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.dream.R;

public class GalleryCardViewHolder extends RecyclerView.ViewHolder{
    public NetworkImageView gallery_image;
    public TextView gallery_title;
    private View view;
    public GalleryCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        gallery_image = itemView.findViewById(R.id.gallery_image);
        gallery_title = itemView.findViewById(R.id.gallery_title);
    }

    public View getView() {
        return view;
    }
}
