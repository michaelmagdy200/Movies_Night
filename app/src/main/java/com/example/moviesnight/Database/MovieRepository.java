package com.example.moviesnight.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieRepository {


    private MovieDao movieDao ;
    private List<MovieModel> allMovies ;

    public MovieRepository(Application application) {
        MovieDatabase database = MovieDatabase.getInstance(application) ;
        movieDao = database.movieDao();
        allMovies = movieDao.getAllData();
    }
    public void insert (MovieModel movieModel){

        new InsertNodeAsyncTask(movieDao).execute(movieModel) ;

    }
    public void update (MovieModel movieModel){

        new UpdateNodeAsyncTask(movieDao).execute(movieModel) ;
    }
    public void delete (MovieModel movieModel){
        new DeleteNodeAsyncTask(movieDao).execute(movieModel) ;
    }
    public void deleteAllMovies (){
        new DeleteAllNodeAsyncTask(movieDao).execute() ;
    }
    public List<MovieModel> getAllMovies(){
        return allMovies ;
    }
    private static class InsertNodeAsyncTask extends AsyncTask<MovieModel , Void , Void> {
        private MovieDao movieDao ;

        private InsertNodeAsyncTask(MovieDao movieDao){
            this.movieDao = movieDao ;
        }

        @Override
        protected Void doInBackground(MovieModel... movies) {

            movieDao.insert(movies[0]);
            return null;
        }
    }
    private static class UpdateNodeAsyncTask extends AsyncTask<MovieModel , Void , Void> {
        private MovieDao movieDao ;

        private UpdateNodeAsyncTask(MovieDao movieDao){
            this.movieDao = movieDao ;
        }

        @Override
        protected Void doInBackground(MovieModel... movies) {

            movieDao.update(movies[0]);
            return null;
        }
    }
    private static class DeleteNodeAsyncTask extends AsyncTask<MovieModel , Void , Void> {
        private MovieDao movieDao ;

        private DeleteNodeAsyncTask(MovieDao movieDao){
            this.movieDao = movieDao ;
        }

        @Override
        protected Void doInBackground(MovieModel... nodes) {

            movieDao.delete(nodes[0]);
            return null;
        }
    }
    private static class DeleteAllNodeAsyncTask extends AsyncTask<Void , Void , Void> {
        private MovieDao movieDao ;

        private DeleteAllNodeAsyncTask(MovieDao movieDao){
            this.movieDao = movieDao ;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            movieDao.deleteAllData();
            return null;
        }
    }


}
