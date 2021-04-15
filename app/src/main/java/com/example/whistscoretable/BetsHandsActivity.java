package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class BetsHandsActivity extends AppCompatActivity {
    private ArrayList<Player> playersList;
    private boolean isChecking = true;
    private int mCheckedId = R.id.btn0;
    private int noPlayers, cnt=0, round, hands;
    private boolean finishBet=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets_hands);
        playersList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
        noPlayers = (getIntent().getIntExtra("noPlayers",3));
        RadioGroup mFirstGroup = (RadioGroup) findViewById(R.id.first_group);
        RadioGroup mSecondGroup = (RadioGroup) findViewById(R.id.second_group);
        RadioGroup mThirdGroup = (RadioGroup) findViewById(R.id.third_group);
        mFirstGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mSecondGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });
        mSecondGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });
        mThirdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mSecondGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });
        TextView showName = (TextView) findViewById(R.id.showName);
        showName.setText(playersList.get(0).getName());
    }


    public void onClickPlaceBet(View view) {
            isChecked();
            if(finishBet) {
                Intent checkBets = new Intent(this, CheckBetsActivity.class);
                Bundle passPlayersList = new Bundle();
                passPlayersList.putSerializable("playerList",(Serializable) playersList);
                checkBets.putExtras(passPlayersList);
                checkBets.putExtra("noPlayers",noPlayers);
                startActivity(checkBets);
            }
    }

    public void isChecked(){
        if (mCheckedId == R.id.btn0) {
            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
            setPlayerBet(0);
        } else if (mCheckedId == R.id.btn1) {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            setPlayerBet(1);
        } else if (mCheckedId == R.id.btn2) {
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            setPlayerBet(2);
        } else if (mCheckedId == R.id.btn3) {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            setPlayerBet(3);
        } else if (mCheckedId == R.id.btn4) {
            Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
            setPlayerBet(4);
        } else if (mCheckedId == R.id.btn5) {
            Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
            setPlayerBet(5);
        } else if (mCheckedId == R.id.btn6) {
            Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
            setPlayerBet(6);
        } else if (mCheckedId == R.id.btn7) {
            Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
            setPlayerBet(7);
        } else if (mCheckedId == R.id.btn8) {
            Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
            setPlayerBet(8);
        }
    }

    public void setPlayerBet(int bet){
        TextView showName = (TextView) findViewById(R.id.showName);
        if(cnt<noPlayers-1)
        {
            showName.setText(playersList.get(cnt+1).getName());
        }
        playersList.get(cnt).setBet(bet);
        cnt++;
        if(cnt==noPlayers) {
            finishBet = true;
        }
    }
}