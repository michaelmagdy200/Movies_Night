package com.example.moviesnight;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesnight.data.MovieClient;
import com.example.moviesnight.Database.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView ;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recycleView);
        final MovieAdapter adapter = new MovieAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       Call<List<MovieModel>> userList = MovieClient.getUserMovies().getMovies();
       userList.enqueue(new Callback<List<MovieModel>>() {
           @Override
           public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                if (response.isSuccessful()){

                    List<MovieModel> userResponse = response.body();
                    adapter.setList(userResponse);
                    recyclerView.setAdapter(adapter);

                }
           }

           @Override
           public void onFailure(Call<List<MovieModel>> call, Throwable t) {
               Toast.makeText(getActivity(),"Fail" , Toast.LENGTH_SHORT).show();

           }
       });
        return root ;


    }
}