package com.example.whistscoretable;

import java.io.Serializable;
import java.util.ArrayList;

public class CurrentGame implements Serializable {
    private int noHands, round, noPlayers, noRounds;
    private ArrayList<Player> playersList = new ArrayList<>();

    public int getNoHands() {
        return noHands;
    }

    public void setNoHands(int noHands) {
        this.noHands = noHands;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getNoPlayers() {
        return noPlayers;
    }

    public void setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    public int getNoRounds() {
        return noRounds;
    }

    public void setNoRounds(int noRounds) {
        this.noRounds = noRounds;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }


}
