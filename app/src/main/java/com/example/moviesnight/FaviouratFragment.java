package com.example.moviesnight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.moviesnight.Database.MovieDatabase;
import com.example.moviesnight.Database.MovieViewModel;
import com.example.moviesnight.Database.MovieModel;

import java.util.ArrayList;
import java.util.List;


public class FaviouratFragment extends Fragment {


    private RecyclerView recyclerView;
    private MovieDatabase database ;
    private MovieViewModel movieViewModel ;
    List<MovieModel> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        database = MovieDatabase.getInstance(getActivity());
        list = database.movieDao().getAllData();
        recyclerView = root.findViewById(R.id.recycleView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        final FaviouretAdapter adapter2 = new FaviouretAdapter();
        recyclerView.setAdapter(adapter2);
//        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
//        movieViewModel.getAllMovies().observe(getActivity(), new Observer<List<MovieModel>>() {
//            @Override
//            public void onChanged(List<MovieModel> movieModels) {
//                adapter2.setMovieList(movieModels );
//            }
//        });
        return root;
    }
}