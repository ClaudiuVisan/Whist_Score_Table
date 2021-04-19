package com.example.whistscoretable;

import java.io.Serializable;

public class Player implements Serializable {
    private int score, bet, result;
    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Player(){
        score=0;
        name="TBD";
        bet=0;
    }

}
