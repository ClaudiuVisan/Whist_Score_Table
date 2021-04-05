package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import java.io.Serializable;
import java.util.ArrayList;

public class add_players extends AppCompatActivity {
    private int noPlayers;
    private boolean modif=false;
    private ArrayList<Player> playerList = new ArrayList<>();
    LinearLayout myLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        Intent intent1 = getIntent();
        Button placeHolder=(Button) findViewById(R.id.placeHolder);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button start_game=(Button) findViewById(R.id.start_game);
        start_game.setEnabled(false);
        placeHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noPlayersstr=String.valueOf(spinner.getSelectedItem()) ;
                noPlayers=Integer.parseInt(noPlayersstr);
                addPlayers();
                start_game.setEnabled(true);

            }
        });
    }

    public void onClickStartGame(View view){
        Intent start = new Intent(add_players.this,Score.class);
        Bundle passPlayers=new Bundle();
        for(int i=1;i<=noPlayers;i++)
        {
            Player newPlayer = new Player();
            EditText caset = (EditText) findViewById(i+R.id.playerName);
            newPlayer.setName(caset.getText().toString());
            playerList.add(newPlayer);
            passPlayers.putSerializable("playerList",(Serializable) playerList);
        }
        start.putExtras(passPlayers);
        start.putExtra("noPlayers",noPlayers);
        startActivity(start);

    }

    public void addPlayers(){
        if(modif)
        {
            for(int i=1;i<=6;i++)
            {
                EditText caset = (EditText) findViewById(i+R.id.playerName);
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
            caseta.setId(i+R.id.playerName);
            myLayout.addView(caseta, myParams);
        }
        modif=true;
    }
}
