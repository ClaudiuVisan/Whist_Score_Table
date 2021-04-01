package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class add_players extends AppCompatActivity {
    private int noPlayers,nr;
    private boolean modif=false;
    LinearLayout myLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        Intent intent = getIntent();
        Button placeHolder=(Button) findViewById(R.id.placeHolder);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        placeHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noPlayersstr=String.valueOf(spinner.getSelectedItem()) ;
                noPlayers=Integer.parseInt(noPlayersstr);
                addPlayers();
            }
        });
    }

    public void addPlayers(){
        if(modif)
        {
            for(int i=1;i<=6;i++)
            {
                EditText caset = (EditText) findViewById(i+100);
                myLayout.removeView(caset);
            }
        }
        int i;
        for(i=1;i<=noPlayers;i++)
        {
            myLayout=(LinearLayout) findViewById(R.id.myLayout);
            LinearLayout.LayoutParams myParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            EditText caseta = new EditText(add_players.this);
            caseta.setHint("Player "+i);
            caseta.setSingleLine(true);
            caseta.setId(i+100);
            myLayout.addView(caseta, myParams);
        }
        modif=true;
    }
}
