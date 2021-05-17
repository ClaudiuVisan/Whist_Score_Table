package com.example.whistscoretable;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.whistscoretable.Converters;
import com.example.whistscoretable.CurrentGame;

@Database(entities = {CurrentGame.class}, version=4)
//@Database (entities = {Player.class},version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract GameDao gameDao();
}