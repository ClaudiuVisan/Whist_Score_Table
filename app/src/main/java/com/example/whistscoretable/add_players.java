package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class add_players extends AppCompatActivity {
    LinearLayout myLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_players);
        int i;
        for(i=1;i<=3;i++)
        {
            myLayout=(LinearLayout) findViewById(R.id.myLayout);
            LinearLayout.LayoutParams myParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            EditText caseta = new EditText(add_players.this);
            caseta.setText("Jucatorul "+i);
            caseta.setId(i);
            myLayout.addView(caseta, myParams);
        }
    }
}