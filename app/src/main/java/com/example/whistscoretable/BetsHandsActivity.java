package com.example.whistscoretable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class BetsHandsActivity extends AppCompatActivity {
    private CurrentGame currentGame;
    private boolean isChecking = true;
    private int mCheckedId = R.id.btn0;
    private int cnt=0;
    private boolean finishBet=false;
    private final int[] idList={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets_hands);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        currentGame.setRound(currentGame.getRound()+1);
        Button placeBet= findViewById(R.id.setBet);
        placeBet.setEnabled(false);
        RadioGroup mFirstGroup =  findViewById(R.id.first_group);
        RadioGroup mSecondGroup =  findViewById(R.id.second_group);
        RadioGroup mThirdGroup =  findViewById(R.id.third_group);
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
                Button placeBet= findViewById(R.id.setBet);
                placeBet.setEnabled(true);
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
                Button placeBet= findViewById(R.id.setBet);
                placeBet.setEnabled(true);
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
                Button placeBet=findViewById(R.id.setBet);
                placeBet.setEnabled(true);
            }
        });

        disableBets();
        TextView showName = findViewById(R.id.showName);
        showName.setText(currentGame.getPlayersList().get(0).getName());
    }


    public void onClickPlaceBet(View view) {
        isChecked();
        if(finishBet) {
            Intent checkBets = new Intent(this, CheckBetsActivity.class);
            Bundle passCurrentGame = new Bundle();
            passCurrentGame.putSerializable("currentGame",currentGame);
            checkBets.putExtras(passCurrentGame);
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
        TextView showName = findViewById(R.id.showName);
        if(cnt<currentGame.getNoPlayers()-1)
        {
            showName.setText(currentGame.getPlayersList().get(cnt+1).getName());
        }

        currentGame.getPlayersList().get(cnt).setBet(bet);
        if(cnt==currentGame.getNoPlayers()-2)
        {
            disableLastBet();
        }
        cnt++;
        if(cnt==currentGame.getNoPlayers()) {
            finishBet = true;
        }
    }

    public void disableBets()
    {

        for(int i=currentGame.getHandsList()[currentGame.getRound()]+1;i<=8;i++)
        {
            RadioButton crtButton = findViewById(idList[i]);
            crtButton.setEnabled(false);
            crtButton.setBackgroundResource(R.drawable.radio_disabled);
        }
    }

    public void disableLastBet()
    {
        int forbid=currentGame.getNoHands();
        for(int i=0;i<currentGame.getNoPlayers()-1;i++)
        {
            forbid=forbid-currentGame.getPlayersList().get(i).getBet();
        }
        if(forbid>=0)
        {
            RadioButton crtButton = findViewById(idList[forbid]);
            crtButton.setEnabled(false);
            crtButton.setBackgroundResource(R.drawable.radio_disabled);
        }
    }

}
