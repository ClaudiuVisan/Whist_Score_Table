package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ArrayList<Player> playerList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
        int noPlayers=(getIntent().getIntExtra("noPlayers",2));
        TableLayout tabel = (TableLayout) findViewById(R.id.tabel);
        tabel.setColumnStretchable(1, true);
        tabel.setColumnStretchable(2, true);
        tabel.setStretchAllColumns(true);


        for(int i=1;i<=noPlayers;i++)
        {
            TableRow rand = new TableRow(this);
            TableRow.LayoutParams myParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            rand.setLayoutParams(myParams);
            TextView casetNume = new TextView(this);
            casetNume.setText(playerList.get(i-1).getName());

            rand.addView(casetNume);
            TextView casetScor = new TextView(this);
            casetScor.setText("69");

            rand.addView(casetScor);
            tabel.addView(rand);

        }
    }
}