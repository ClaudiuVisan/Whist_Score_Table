package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class add_players extends AppCompatActivity {
    private int noPlayers,n=0;
    private boolean modif=false;
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private Button start_game;
    LinearLayout myLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        Intent intent1 = getIntent();
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

        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=1;i<=noPlayers;i++)
                {
                    Player newPlayer = new Player();
                    EditText caset = (EditText) findViewById(i+100);
                    newPlayer.setName(caset.getText().toString());
                    playerList.add(newPlayer);
                    n++;
                }
                Intent intent2 = new Intent(add_players.this, Score.class);
                intent2.putExtra("playerList", playerList);
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
            Button butonski= (Button) findViewById(150);
            myLayout.removeView(butonski);
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
        start_game = new Button(add_players.this);
        myLayout=(LinearLayout) findViewById(R.id.myLayout);
        LinearLayout.LayoutParams myParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        start_game.setText("START GAME");
        start_game.setId(150);
        //start_game.setGravity(Gravity.CENTER_HORIZONTAL);
        myLayout.addView(start_game, myParams);
    }
}
