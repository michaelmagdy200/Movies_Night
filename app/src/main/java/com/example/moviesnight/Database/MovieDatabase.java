package com.example.moviesnight.Database;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = MovieModel.class , exportSchema = false , version = 1)

public abstract class MovieDatabase extends RoomDatabase
{
    private static final String DB_NAME = "movie_database" ;
    private static MovieDatabase instance ;
    public abstract MovieDao movieDao ();

    public static synchronized MovieDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, MovieDatabase.class , DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance ;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

    };
    private static class popularDbAsyncTask extends AsyncTask<Void , Void , Void> {

        private MovieDao movieDao;

        private popularDbAsyncTask(MovieDatabase db){
            movieDao = db.movieDao() ;
            new popularDbAsyncTask(instance).execute();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            movieDao.insert(new MovieModel("Name 1", "image 1" ));
            movieDao.insert(new MovieModel("Name 2", "image 2"));
            movieDao.insert(new MovieModel("Name 3", "image 3"));
            return null;

        }
    }
}
