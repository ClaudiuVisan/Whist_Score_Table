package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.io.Serializable;


public class ScoreTableActivity extends AppCompatActivity {
    private CurrentGame currentGame;
    private TableLayout scoreTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        if(currentGame.getRound()==currentGame.getNoRounds())
        {
            currentGame.setGameFinish(true);
        }
        setScoreTable(currentGame.getNoPlayers());
        Button placeBets = (Button) findViewById(R.id.placeBets);
        placeBets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentGame.getRound()>0)
                {
                    currentGame.rotatePlayers();
                }
                checkActivity();
            }
        });

    }

   public void setScoreTable(int noPlayers)
   {
       scoreTable = (TableLayout) findViewById(R.id.tabel);
       scoreTable.setVerticalGravity(Gravity.CENTER_VERTICAL);
       scoreTable.setColumnStretchable(0,true);
       scoreTable.setColumnStretchable(1,true);
       scoreTable.setVerticalGravity(Gravity.START);
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
           casetScor.setGravity(Gravity.RIGHT);
           rand.addView(casetNume,myParams);
           rand.addView(casetScor,myParams);
           scoreTable.addView(rand,myParams);
       }
   }

   public void checkActivity()
   {
       Intent bets = new Intent(ScoreTableActivity.this, BetsHandsActivity.class);
       Intent finalScore=new Intent(ScoreTableActivity.this,FinalScoreActivity.class);
       Bundle passCurrentGame = new Bundle();
       passCurrentGame.putSerializable("currentGame",(Serializable) currentGame);
       bets.putExtras(passCurrentGame);
       finalScore.putExtras(passCurrentGame);
       startActivity(finalScore);
      /* if(currentGame.isGameFinish()){
           startActivity(finalScore);
       }else{
           startActivity(bets);
       }*/
   }
}

