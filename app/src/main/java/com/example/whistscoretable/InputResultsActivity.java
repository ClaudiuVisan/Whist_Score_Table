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

public class InputResultsActivity extends AppCompatActivity {

    private ArrayList<Player> playersList;
    private boolean isChecking = true;
    private int mCheckedId = R.id.btn00;
    private int noPlayers, index =0,result=0;
    private boolean finishInput =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_results);
        playersList = (ArrayList<Player>) getIntent().getSerializableExtra("playerList");
        noPlayers = (getIntent().getIntExtra("noPlayers",3));
        RadioGroup mFirstGroup = (RadioGroup) findViewById(R.id.first_groupRes);
        RadioGroup mSecondGroup = (RadioGroup) findViewById(R.id.second_groupRes);
        RadioGroup mThirdGroup = (RadioGroup) findViewById(R.id.third_groupRes);
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
        TextView showName = (TextView) findViewById(R.id.showResultName);
        showName.setText(playersList.get(0).getName());
    }


    public void onClickInputResult(View view) {
        isChecked();
        if(finishInput) {
            setPlayersScore();
            Intent viewScore = new Intent(this, ScoreTableActivity.class);
            Bundle passPlayersList = new Bundle();
            passPlayersList.putSerializable("playerList",(Serializable) playersList);
            viewScore.putExtras(passPlayersList);
            viewScore.putExtra("noPlayers",noPlayers);
            startActivity(viewScore);
        }
    }

    public void isChecked(){
        if (mCheckedId == R.id.btn00) {
            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
            result=0;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn01) {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            result=1;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn02) {
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            result=2;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn03) {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            result=3;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn04) {
            Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
            result=4;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn05) {
            Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
            result=5;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn06) {
            Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
            result=6;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn07) {
            Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
            result=7;
            setPlayerResult();
        } else if (mCheckedId == R.id.btn08) {
            Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
            result=8;
            setPlayerResult();
        }
    }

    public void setPlayerResult(){
        TextView showName = (TextView) findViewById(R.id.showResultName);
        if(index <noPlayers-1)
        {
            showName.setText(playersList.get(index +1).getName());
        }
        playersList.get(index).setResult(result);
        index++;
        if(index==noPlayers) {
            finishInput = true;
        }
    }

    public void setPlayersScore(){
        for(int i=0;i<noPlayers;i++)
        {
            if(playersList.get(i).getBet()==playersList.get(i).getResult())
            {
                playersList.get(i).setScore(playersList.get(i).getScore()+5+playersList.get(i).getBet());
            }
            else{
                playersList.get(i).setScore(playersList.get(i).getScore()-Math.abs(playersList.get(i).getBet()-playersList.get(i).getResult()));
            }
        }
    }


}