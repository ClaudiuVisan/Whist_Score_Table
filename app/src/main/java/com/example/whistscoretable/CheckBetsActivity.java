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

public class CheckBetsActivity extends AppCompatActivity {

    private ArrayList<Player> playersList;
    private TableLayout betTable;
    private int noPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_bets);
        playersList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
        noPlayers = (getIntent().getIntExtra("noPlayers",3));
        createBetTable(noPlayers);
    }

    public void createBetTable(int noPlayers)
    {
        betTable = (TableLayout) findViewById(R.id.betTable);
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
            casetNume.setText(playersList.get(i-1).getName());
            casetBet.setText(String.valueOf(playersList.get(i-1).getBet()));
            casetNume.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            casetNume.setWidth(TypedValue.COMPLEX_UNIT_DIP*720);
            casetBet.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            casetBet.setGravity(Gravity.RIGHT);
            rand.addView(casetNume,myParams);
            rand.addView(casetBet,myParams);
            betTable.addView(rand,myParams);
        }
    }
    public void onClickFinishCheck(View view)
    {
        Intent finishCheck = new Intent(this, InputResultsActivity.class);
        Bundle passPlayersList = new Bundle();
        passPlayersList.putSerializable("playerList",(Serializable) playersList);
        finishCheck.putExtras(passPlayersList);
        finishCheck.putExtra("noPlayers",noPlayers);
        startActivity(finishCheck);
    }
}