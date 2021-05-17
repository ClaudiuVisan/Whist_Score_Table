package com.example.whistscoretable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.whistscoretable.CurrentGame;

import java.util.List;
@Dao
public interface GameDao {
    @Query("SELECT * FROM currentgame")
    List<CurrentGame> getAllGames();
    @Insert
    void insertAll(CurrentGame... currentGames);

    @Query("DELETE FROM currentgame")
    void deleteAll();

    @Delete
    void delete(CurrentGame game);

    @Update
    void update(CurrentGame... game);
}