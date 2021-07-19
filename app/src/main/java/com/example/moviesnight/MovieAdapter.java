package com.example.moviesnight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import com.example.moviesnight.Database.MovieDatabase;
import com.example.moviesnight.Database.MovieModel;
import com.example.moviesnight.Database.MovieRepository;
import com.example.moviesnight.Database.MovieViewModel;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieModel> movieList = new ArrayList<>();
    private MovieRepository movieRepository ;
    public static   MovieDatabase movieDatabase ;
    MovieModel movieModel = new MovieModel() ;
    Context context ;
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder (LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {



        holder.movieName.setText(movieList.get(position).getName());
        Picasso.get().load(movieList.get(position).getImageurl()).into(holder.movieImage);
        holder.likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLikeDrawableRes(R.drawable.heart_on);
//                movieDatabase = MovieDatabase.getInstance(context);
//                MovieModel model = movieList.get(holder.getAdapterPosition());
//                movieRepository.insert(model);
                Toast.makeText(likeButton.getContext(), "Added to favourite", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setUnlikeDrawableRes(R.drawable.heart_off);
                MovieModel model = movieList.get(holder.getAdapterPosition());
                movieDatabase.movieDao().delete(model);
                Toast.makeText(likeButton.getContext(), "Removed from favourite", Toast.LENGTH_SHORT).show();
                int p = holder.getAdapterPosition();
                movieList.remove(p);
                notifyItemRemoved(p);
                notifyItemRangeChanged(p , movieList.size());
            }
        });
    }



    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public void setList( List<MovieModel> movieList){
        this.movieList = movieList ;
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
