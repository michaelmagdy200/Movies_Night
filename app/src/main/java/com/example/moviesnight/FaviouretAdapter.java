package com.example.moviesnight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesnight.Database.MovieDatabase;
import com.example.moviesnight.Database.MovieModel;
import com.example.moviesnight.Database.MovieRepository;
import com.like.LikeButton;

import java.util.ArrayList;
import java.util.List;

public class FaviouretAdapter extends RecyclerView.Adapter<FaviouretAdapter.MovieViewHolder> {
    public List<MovieModel> movieList22 = new ArrayList<>();
    private Context context ;
    private MovieRepository movieRepository ;
    public static MovieDatabase movieDatabase ;
    private boolean update ;
    @NonNull
    @Override
    public FaviouretAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FaviouretAdapter.MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        movieDatabase = MovieDatabase.getInstance(context);
    }

    @Override
    public int getItemCount() {
        return movieList22.size();
    }

    public void setMovieList(Context context , List<MovieModel> movieList){
        this.context = context ;
        this.movieList22 = movieList ;
        notifyDataSetChanged();
    }
    public class  MovieViewHolder extends RecyclerView.ViewHolder{
        TextView movieName ;
        ImageView movieImage ;
        LikeButton likeButton ;
        public MovieViewHolder(@NonNull final View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageView);
            movieName =itemView.findViewById(R.id.textView);
            likeButton = itemView.findViewById(R.id.likebutton);

        }
    }

}
