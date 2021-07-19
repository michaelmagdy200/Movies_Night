package com.example.moviesnight.data;

import com.example.moviesnight.Database.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInterface {
    @GET("marvel/")
    public Call<List<MovieModel>> getMovies() ;

}
