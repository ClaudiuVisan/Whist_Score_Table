package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.Comparator;

public class FinalScoreActivity extends AppCompatActivity {

    private CurrentGame currentGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        currentGame.getPlayersList().sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p2.getScore(), p1.getScore());
            }
        });
        setFinalScoreTable();
    }

    public void setFinalScoreTable()
    {
        TableLayout finalScoreTable = findViewById(R.id.tabelFinal);
        finalScoreTable.setVerticalGravity(Gravity.CENTER_VERTICAL);
        finalScoreTable.setColumnStretchable(0,true);
        finalScoreTable.setColumnStretchable(1,true);
        finalScoreTable.setVerticalGravity(Gravity.START);
        for(int i=1;i<=currentGame.getNoPlayers();i++)
        {
            TableRow rand = new TableRow(this);
            TableRow.LayoutParams myParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
            rand.setLayoutParams(myParams);
            TextView casetNume = new TextView(this);
            TextView casetScor = new TextView(this);
            casetNume.setText(currentGame.getPlayersList().get(i-1).getName());
            casetScor.setText(String.valueOf(currentGame.getPlayersList().get(i-1).getScore()));
            casetNume.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            casetNume.setWidth(TypedValue.COMPLEX_UNIT_DIP*41);
            casetScor.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            casetScor.setGravity(Gravity.END);
            rand.addView(casetNume,myParams);
            rand.addView(casetScor,myParams);
            finalScoreTable.addView(rand,myParams);
        }
    }
    public void onClickEndGame(View view){
        Intent endGame = new Intent(this, MenuActivity.class);
        startActivity(endGame);
    }
}