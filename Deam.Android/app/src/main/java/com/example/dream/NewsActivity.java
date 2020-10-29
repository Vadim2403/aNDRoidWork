package com.example.dream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dream.network.NetworkService;
import com.example.dream.network.Tokens;
import com.example.dream.network.University;
import com.example.dream.newsview.NewsCardRecyclerViewAdapter;
import com.example.dream.newsview.NewsGridItemDecoration;
import com.example.dream.newsview.NewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsCardRecyclerViewAdapter adapter;
    private List<NewsModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.recycler_view);


        setRecyclerView();

        NetworkService.getInstance()
               .getJSONApi()
               .getUniv()
               .enqueue(new Callback<List<University>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<University>> call, @NonNull Response<List<University>> response) {
                        if (response.errorBody() == null && response.isSuccessful()) {
                            List<University> post = response.body();
                            list.clear();
                            for(University item: post)
                            {
                                NewsModel model = new NewsModel(item.getImage(), item.getName());
                                list.add(model);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Not valid login or password" , Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<List<University>> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        NewsModel model = new NewsModel("https://www.growthengineering.co.uk/wp-content/uploads/2014/07/To-Do-List.png", "Hello");
        list.add(model);
        NewsModel model1 = new NewsModel("https://i.guim.co.uk/img/media/20098ae982d6b3ba4d70ede3ef9b8f79ab1205ce/0_0_969_581/master/969.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=a368f449b1cc1f37412c07a1bd901fb5", "Навала короновіруса");
        list.add(model1);
        adapter = new NewsCardRecyclerViewAdapter(list);

        recyclerView.setAdapter(adapter);

        int largePadding = 16;
        int smallPadding = 4;
        recyclerView.addItemDecoration(new NewsGridItemDecoration(largePadding, smallPadding));
    }
}