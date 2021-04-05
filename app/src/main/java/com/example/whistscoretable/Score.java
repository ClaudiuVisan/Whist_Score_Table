package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
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
        ArrayList<Player> playersList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
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
            TextView casetScor = new TextView(this);
            casetNume.setText(playersList.get(i-1).getName());
            casetScor.setText(String.valueOf(playersList.get(i-1).getScore()));
            casetNume.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
            casetScor.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
            casetScor.setGravity(Gravity.RIGHT);
            rand.addView(casetNume);
            rand.addView(casetScor);
            tabel.addView(rand);

        }
    }
}