package com.example.moviesnight.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {

    private static final String Base_URL = "https://simplifiedcoding.net/demos/";
    private static MovieClient INSTANCE ;

    private static Retrofit MovieClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit ;
    }

    public static MovieInterface getUserMovies(){
        MovieInterface movieInterface = MovieClient().create(MovieInterface.class);
        return movieInterface ;
    }
}
