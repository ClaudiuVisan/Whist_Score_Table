package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
            Player newPlayer = (Player) getIntent().getSerializableExtra("playerList");
            String name = newPlayer.getName();
            TextView pl = (TextView) findViewById(R.id.p);
            pl.setText(name);
    }

}