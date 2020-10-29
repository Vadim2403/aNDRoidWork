package com.example.dream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.example.dream.network.ImageRequester;
import com.example.dream.network.NetworkService;
import com.example.dream.network.Post;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textVtestGet;
    private ImageRequester imageRequester;
    private NetworkImageView editImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e("Semen","----Hello Peter-----");
        //Log.d("slava", "------dispaly----");
        setContentView(R.layout.activity_main);
        imageRequester = ImageRequester.getInstance();
        editImage = findViewById(R.id.chooseImage);
        imageRequester.setImageFromUrl(editImage,"https://n1s2.hsmedia.ru/05/a8/93/05a893a483fdb95c14cb8376cbe108a3/440x326_21_ea602dbd9464a8f541855895da03cc01@690x460_0xc0a8392b_17375271931512042076.jpeg");
        textVtestGet = findViewById(R.id.textVtestGet);
    }

    public void btnClickPlus(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Нажатий плюс", Toast.LENGTH_LONG);
        toast.show();
    }

    public void btnClickcalculator(View v) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
    public void btnlogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void btnNews(View v) {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
    public void btnGallery(View v) {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    public void TestGet(View v) {
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textVtestGet.append(post.getId() + "\n");
                        textVtestGet.append(post.getUserId() + "\n");
                        textVtestGet.append(post.getTitle() + "\n");
                        textVtestGet.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textVtestGet.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}