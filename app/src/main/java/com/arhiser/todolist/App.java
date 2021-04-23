package com.arhiser.todolist;

import android.app.Application;

import androidx.room.Room;

import com.arhiser.todolist.data.AppDatabase;
import com.arhiser.todolist.data.ToDoDao;

public class App extends Application {

    private AppDatabase database;
    private ToDoDao toDoDao;

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        toDoDao = database.noteDao();
    }

    public ToDoDao getToDoDao() {
        return toDoDao;
    }
}
