package com.example.whistscoretable;

import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.whistscoretable.CurrentGame;

import java.util.List;
@Dao
public interface GameDao {
    @Query("SELECT * FROM currentgame")
    List<CurrentGame> getAllGames();
    @Insert
    void insertAll(CurrentGame... currentGames);

}