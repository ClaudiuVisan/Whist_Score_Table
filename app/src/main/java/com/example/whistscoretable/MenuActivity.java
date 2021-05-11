package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
         //AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().fallbackToDestructiveMigration().build();
         //db.gameDao().deleteAll();
    }

    public void onClickNewGame(View view){
        Intent newGame = new Intent(this, AddPlayersActivity.class);
        startActivity(newGame);
    }

    public void onClickLoadGame(View view){
        // Implementare activity load game
        // TO DO
        Intent loadGame = new Intent (this, LoadGameActivity.class);
        startActivity(loadGame);
    }
}

