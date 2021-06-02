package ru.mirea.kudriashov.mireaproject.ui.history;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ru.mirea.kudriashov.mireaproject.ui.history.Cell.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ru.mirea.kudriashov.mireaproject.ui.history.HistoryDao storyDao();
}

