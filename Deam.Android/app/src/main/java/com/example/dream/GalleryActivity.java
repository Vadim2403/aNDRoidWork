package com.example.dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dream.galleryview.GalleryCardRecyclerViewAdapter;
import com.example.dream.galleryview.GalleryGridItemDecoration;
import com.example.dream.galleryview.GalleryModel;
import com.example.dream.newsview.NewsCardRecyclerViewAdapter;
import com.example.dream.newsview.NewsGridItemDecoration;
import com.example.dream.newsview.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GalleryCardRecyclerViewAdapter adapter;
    private List<GalleryModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recyclerView = findViewById(R.id.recycler_view);


       setRecyclerView();

    }
    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        GalleryModel model = new GalleryModel("https://24smi.org/public/media/celebrity/2016/08/15/1471241770-gal-gadot.jpg", "Я");
        list.add(model);
        GalleryModel model1 = new GalleryModel("https://m.spletnik.ru/img/2017/06/nastya/20170609-galgadot-post.jpg", "Манала ");
        list.add(model1);
        GalleryModel model2 = new GalleryModel("https://24smi.org/public/media/celebrity/2016/08/15/1471241770-gal-gadot.jpg", "Пахать");
        list.add(model2);
        GalleryModel model3 = new GalleryModel("https://m.spletnik.ru/img/2017/06/nastya/20170609-galgadot-post.jpg", "На дядю");
        list.add(model3);
        adapter = new GalleryCardRecyclerViewAdapter(list);

        recyclerView.setAdapter(adapter);

        int largePadding = 16;
        int smallPadding = 4;
        recyclerView.addItemDecoration(new GalleryGridItemDecoration(largePadding, smallPadding));
    }
}