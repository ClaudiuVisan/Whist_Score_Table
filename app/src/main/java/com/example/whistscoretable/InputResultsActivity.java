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


public class InputResultsActivity extends AppCompatActivity {

    private CurrentGame currentGame;
    private boolean isChecking = true;
    private int mCheckedId = R.id.btn00;
    private int index =0,result=0;
    private boolean finishInput =false;
    private final int[] idList={R.id.btn00,R.id.btn01,R.id.btn02,R.id.btn03,R.id.btn04,R.id.btn05,R.id.btn06,R.id.btn07,R.id.btn08};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_results);
        Button setRes=findViewById(R.id.setResult);
        setRes.setEnabled(false);
        currentGame = (CurrentGame) getIntent().getSerializableExtra("currentGame");
        RadioGroup mFirstGroup = findViewById(R.id.first_groupRes);
        RadioGroup mSecondGroup = findViewById(R.id.second_groupRes);
        RadioGroup mThirdGroup =  findViewById(R.id.third_groupRes);
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
                Button setRes=findViewById(R.id.setResult);
                setRes.setEnabled(true);
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
                Button setRes=findViewById(R.id.setResult);
                setRes.setEnabled(true);
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
                Button setRes=findViewById(R.id.setResult);
                setRes.setEnabled(true);
            }
        });
        disableResults();
        TextView showName =findViewById(R.id.showResultName);
        showName.setText(currentGame.getPlayersList().get(0).getName());
    }


    public void onClickInputResult(View view) {
        isChecked();
    if(finishInput) {
            setPlayersScore();
            Intent viewScore = new Intent(this, ScoreTableActivity.class);
            Bundle passCurrentGame = new Bundle();
            passCurrentGame.putSerializable("currentGame", currentGame);
            viewScore.putExtras(passCurrentGame);
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
        TextView showName = findViewById(R.id.showResultName);
        if(index <currentGame.getNoPlayers()-1)
        {
            showName.setText(currentGame.getPlayersList().get(index +1).getName());
        }
        currentGame.getPlayersList().get(index).setResult(result);
        if(index<currentGame.getNoPlayers()-1)
            { disableCrtResult(); }
        index++;
        if(index==currentGame.getNoPlayers()) {
            finishInput = true;
        }
    }

    public void setPlayersScore(){
        for(int i=0;i<currentGame.getNoPlayers();i++)
        {
            if(currentGame.getPlayersList().get(i).getBet()==currentGame.getPlayersList().get(i).getResult())
            {
                currentGame.getPlayersList().get(i).setScore(currentGame.getPlayersList().get(i).getScore()+5+currentGame.getPlayersList().get(i).getBet());
            }
            else{
                currentGame.getPlayersList().get(i).setScore(currentGame.getPlayersList().get(i).getScore()-Math.abs(currentGame.getPlayersList().get(i).getBet()-currentGame.getPlayersList().get(i).getResult()));
            }
        }
    }

    public void disableResults(){
        int[] idList={R.id.btn00,R.id.btn01,R.id.btn02,R.id.btn03,R.id.btn04,R.id.btn05,R.id.btn06,R.id.btn07,R.id.btn08};
        for(int i=currentGame.getHandsList()[currentGame.getRound()]+1;i<=8;i++)
        {
            RadioButton crtButton = findViewById(idList[i]);
            crtButton.setEnabled(false);
            crtButton.setBackgroundResource(R.drawable.radio_disabled);
        }
    }


    public void disableCrtResult()
    {
        int limit=currentGame.getNoHands();
        for(int i=0;i<=index;i++)
        {
            limit=limit-currentGame.getPlayersList().get(i).getResult();
        }
        if(index<currentGame.getNoPlayers()-2)
        {
            for(int i=limit+1;i<=currentGame.getNoHands();i++)
            {
                RadioButton crtButton = findViewById(idList[i]);
                crtButton.setEnabled(false);
                crtButton.setBackgroundResource(R.drawable.radio_disabled);
            }
        }
        else for(int i=0;i<=currentGame.getNoHands();i++)
        {
           if(i!=limit)
           {
               RadioButton crtButton = findViewById(idList[i]);
               crtButton.setEnabled(false);
               crtButton.setBackgroundResource(R.drawable.radio_disabled);
           }
        }
    }

}
