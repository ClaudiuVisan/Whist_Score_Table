package com.example.whistscoretable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class CurrentGame implements Serializable {
    //private final int noHands;
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "round")
    private int round;
    @ColumnInfo(name = "no_players")
    private int noPlayers;
    @ColumnInfo(name = "no_rounds")
    private int noRounds;
    @Ignore
    private int handsList[];
    @Ignore
    //@ColumnInfo(name = "players_list")
    private ArrayList<Player> playersList = new ArrayList<>();
    @ColumnInfo(name = "game_finish")
    private boolean gameFinish;
    private String name;


    CurrentGame()
    {
        round=0;
        //noHands=8;
        gameFinish=false;
    }

   /* public int getNoHands() {
        return noHands;
    }*/

  /*  public void setNoHands(int noHands) {
        this.noHands = noHands;
    }*/

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

    public void rotatePlayers()
    {
        Player x = playersList.get(0);
        for(int i=0;i<noPlayers-1;i++)
        {
            playersList.set(i,playersList.get(i+1));
        }
        playersList.set(noPlayers-1,x);
    }

    public void createHands()
    {
        handsList = new int[noRounds+1];
        for(int i=0;i<=noRounds;i++)
        {
            if(i<=noPlayers) { handsList[i] = 8; }
            else if(i<=noPlayers+6) { handsList[i] = 8-(i-noPlayers); }
            else if(i<=noPlayers*2+6) { handsList[i] = 1; }
            else if(i<=noPlayers*2+12) { handsList[i] = 1 + (i-2*noPlayers-6); }
            else { handsList[i] = 8; }
        }
    }

    public int[] getHandsList() {
        return handsList;
    }
    public int getNoHands() { return handsList[round]; }

    public boolean isGameFinish() {
        return gameFinish;
    }

    public void setGameFinish(boolean gameFinish) {
        this.gameFinish = gameFinish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
