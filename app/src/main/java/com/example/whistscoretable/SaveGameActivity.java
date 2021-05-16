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
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        EditText gameName = findViewById(R.id.gameName);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        addSavedGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean onSave = true;
                currentGame.setName(gameName.getText().toString());
                db.gameDao().insertAll(currentGame);
                Intent intent = new Intent(SaveGameActivity.this, LoadGameActivity.class);
                Bundle passCurrentGame = new Bundle();
                passCurrentGame.putSerializable("currentGame",currentGame);
                intent.putExtra("fromSave",onSave);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        boolean onSave = true;
        Intent back=new Intent(this,ScoreTableActivity.class);
        Bundle passCurrentGame = new Bundle();
        passCurrentGame.putSerializable("currentGame",currentGame);
        back.putExtras(passCurrentGame);
        back.putExtra("fromSave",onSave);
        startActivity(back);
    }
}