package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ArrayList<Player> playerList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
        int noPlayers=(getIntent().getIntExtra("noPlayers",2));
    }
}