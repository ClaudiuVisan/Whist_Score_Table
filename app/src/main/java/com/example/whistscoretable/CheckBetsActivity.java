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


public class CheckBetsActivity extends AppCompatActivity {

    private CurrentGame currentGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_bets);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        createBetTable(currentGame.getNoPlayers());
    }

     @Override
   public void onBackPressed(){
     currentGame.setRound(currentGame.getRound()-1);
     currentGame.setBackPressed(false);
     Intent back=new Intent(this,BetsHandsActivity.class);
     Bundle passCurrentGame = new Bundle();
     passCurrentGame.putSerializable("currentGame",currentGame);
     back.putExtras(passCurrentGame);
     startActivity(back);
  }

    public void createBetTable(int noPlayers)
    {
        TableLayout betTable = findViewById(R.id.betTable);
        betTable.setVerticalGravity(Gravity.CENTER_VERTICAL);
        betTable.setColumnStretchable(0,true);
        betTable.setColumnStretchable(1,true);
        betTable.setVerticalGravity(Gravity.START);
        for(int i=1;i<=noPlayers;i++)
        {
            TableRow rand = new TableRow(this);
            TableRow.LayoutParams myParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
            rand.setLayoutParams(myParams);
            TextView casetNume = new TextView(this);
            TextView casetBet = new TextView(this);
            casetNume.setText(currentGame.getPlayersList().get(i-1).getName());
            casetBet.setText(String.valueOf(currentGame.getPlayersList().get(i-1).getBet()));
            casetNume.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            casetNume.setWidth(TypedValue.COMPLEX_UNIT_DIP*41);
            casetBet.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            casetBet.setGravity(Gravity.END);
            rand.addView(casetNume,myParams);
            rand.addView(casetBet,myParams);
            betTable.addView(rand,myParams);
        }
    }
    public void onClickFinishCheck(View view)
    {
        Intent finishCheck = new Intent(this, InputResultsActivity.class);
        Bundle passCurrentGame = new Bundle();
        passCurrentGame.putSerializable("currentGame",currentGame);
        finishCheck.putExtras(passCurrentGame);
        startActivity(finishCheck);
    }
}