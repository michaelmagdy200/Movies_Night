package com.example.moviesnight.Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MovieDao {

    @Insert
    void insert(MovieModel movieModel);
    @Update
    void update(MovieModel movieModel);
    @Delete
    void delete(MovieModel movieModel);

    @Query("SELECT * FROM movie_table ORDER BY name DESC ")
    List<MovieModel> getAllData ();

    @Query("DELETE FROM movie_table")
    void deleteAllData ();

}
