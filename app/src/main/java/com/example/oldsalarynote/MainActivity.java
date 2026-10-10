package com.example.oldsalarynote;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oldsalarynote.adapter.ArticleAdapter;
import com.example.oldsalarynote.data.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private static final String FAG = "MainActivity";

private RecyclerView recyclerView;
private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long time = System.currentTimeMillis();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new ArticleAdapter(article ->
                Toast.makeText(this, "点击" + article.title, Toast.LENGTH_SHORT).show());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        adapter.submitList(mockData(10000));



        Log.i(FAG,"onCreate cost:" + (System.currentTimeMillis() - time));
    }
    private List<Article> mockData(int count){
        List<Article> list = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            list.add(new Article(i,"标题" + i, "这是第" + i + "条数据的摘要内容"));
        }
        return list;
    }
    @Override
    protected void onStart() {
        long time = System.currentTimeMillis();
        super.onStart();
        Log.i(FAG,"onStart cost:" + (System.currentTimeMillis() - time));
    }

    @Override
    protected void onPause() {
        long time = System.currentTimeMillis();
        super.onPause();
        Log.i(FAG,"onPause cost:" + (System.currentTimeMillis() - time));

    }

    @Override
    protected void onResume() {
        long time = System.currentTimeMillis();
        super.onResume();
        Log.i(FAG,"onResume cost:" + (System.currentTimeMillis() - time));

    }

    @Override
    protected void onStop() {
        long time = System.currentTimeMillis();
        super.onStop();
        Log.i(FAG,"onStop cost:" + (System.currentTimeMillis() - time));

    }

    @Override
    protected void onDestroy() {
        long time = System.currentTimeMillis();
        super.onDestroy();
        Log.i(FAG,"onDestroy cost:" + (System.currentTimeMillis() - time));
    }

}