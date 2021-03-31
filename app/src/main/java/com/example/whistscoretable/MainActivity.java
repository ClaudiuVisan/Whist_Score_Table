package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int noPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {  // nu cred ca e necesar aici
            noPlayers = savedInstanceState.getInt("noPlayers");
        }
    }
    public void onRadioButtonClicked(View view){
        boolean checked=((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.Players_3:
                if (checked)
                    noPlayers=3;
                break;
            case R.id.Players_4:
                if(checked)
                    noPlayers=4;
                break;
            case R.id.Players_5:
                if (checked)
                    noPlayers=5;
                break;
            case R.id.Players_6:
                if(checked)
                    noPlayers=6;
                break;
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("noPlayers",noPlayers);
    }
    public void onClickNewGame(View view){
        /*Intent intent = new Intent(this,add_players.class)
        startActivity(intent);
         */
    }
    public void onClickLoadGame(View view){
        // Implementare activity load game
    }
}