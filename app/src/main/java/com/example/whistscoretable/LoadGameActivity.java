package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LoadGameActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<CurrentGame> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        games = new ArrayList<>();
        for(int i=0;i<=100;i++)
        {
            CurrentGame xgame = new CurrentGame();
            xgame.setName("Game " + i);
            games.add(xgame);
        }
        adapter = new GameAdapter(games);
        recyclerView.setAdapter(adapter);

    }
}