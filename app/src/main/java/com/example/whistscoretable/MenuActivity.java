package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void onClickNewGame(View view){
        Intent newGame = new Intent(this, AddPlayersActivity.class);
        startActivity(newGame);
    }

    public void onClickLoadGame(View view){
        boolean onSave=false;
        Intent loadGame = new Intent (this, LoadGameActivity.class);
        loadGame.putExtra("fromSave",onSave);
        startActivity(loadGame);
    }
}

