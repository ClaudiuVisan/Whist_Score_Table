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
import java.util.ArrayList;

public class ScoreTableActivity extends AppCompatActivity {
    private ArrayList<Player> playersList;
    private TableLayout tabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        playersList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
        int noPlayers=(getIntent().getIntExtra("noPlayers",3));
        tabelski(noPlayers);
        Button placeBets = (Button) findViewById(R.id.placeBets);
        placeBets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bets = new Intent(ScoreTableActivity.this, BetsHandsActivity.class);
                Bundle passPlayersList = new Bundle();
                passPlayersList.putSerializable("playerList",(Serializable) playersList);
                bets.putExtras(passPlayersList);
                bets.putExtra("noPlayers",noPlayers);
                startActivity(bets);
            }
        });

    }

   public void tabelski(int noPlayers)
   {
       tabel = (TableLayout) findViewById(R.id.tabel);
       tabel.setVerticalGravity(Gravity.CENTER_VERTICAL);
       tabel.setColumnStretchable(0,true);
       tabel.setColumnStretchable(1,true);
       tabel.setVerticalGravity(Gravity.START);
       for(int i=1;i<=noPlayers;i++)
       {
           TableRow rand = new TableRow(this);
           TableRow.LayoutParams myParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
           rand.setLayoutParams(myParams);
           TextView casetNume = new TextView(this);
           TextView casetScor = new TextView(this);
           casetNume.setText(playersList.get(i-1).getName());
           casetScor.setText(String.valueOf(playersList.get(i-1).getScore()));
           casetNume.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
           casetNume.setWidth(TypedValue.COMPLEX_UNIT_DIP*720);
           casetScor.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
           casetScor.setGravity(Gravity.RIGHT);
           rand.addView(casetNume,myParams);
           rand.addView(casetScor,myParams);
           tabel.addView(rand,myParams);
       }
   }
}