package com.example.moviesnight.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository repository ;
    private MovieDao movieDao ;

    private List<MovieModel> allMovies  ;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = new MovieRepository(application);
        allMovies = repository.getAllMovies();
    }
    public void insert(MovieModel node){
        repository.insert(node);
    }
    public void update(MovieModel node){
        repository.update(node);
    }
    public void delete(MovieModel node){
        repository.delete(node);
    }
    public void deleteAllNodes(){
        repository.deleteAllMovies();
    }

    public List<MovieModel> getAllMovies() {
        return allMovies;
    }
}
