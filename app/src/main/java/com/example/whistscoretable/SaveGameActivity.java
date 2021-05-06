package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveGameActivity extends AppCompatActivity {

    private CurrentGame currentGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_game);
        Button addSavedGame = findViewById(R.id.addSavedGame);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();
        EditText gameName = findViewById(R.id.gameName);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        addSavedGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentGame xgame = new CurrentGame();
                xgame.setName(gameName.getText().toString());
                db.gameDao().insertAll(xgame);
                Intent intent = new Intent(SaveGameActivity.this, LoadGameActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent back=new Intent(this,ScoreTableActivity.class);
        Bundle passCurrentGame = new Bundle();
        passCurrentGame.putSerializable("currentGame",currentGame);
        back.putExtras(passCurrentGame);
        startActivity(back);
    }
}