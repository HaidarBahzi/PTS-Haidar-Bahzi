package com.example.aplikasi_pts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.aplikasi_pts.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayList<Game> games = getListGame();

        GameAdapter adapter = new GameAdapter(games);
        binding.rvGame.setLayoutManager(new LinearLayoutManager(this));
        binding.rvGame.setAdapter(adapter);

    }

    private ArrayList<Game> getListGame() {
        String[] gameName = getResources().getStringArray(R.array.listGameName);
        String[] gameGenre = getResources().getStringArray(R.array.listGameGenre);
        String[] gamePrice = getResources().getStringArray(R.array.listGamePrice);
        TypedArray gameImage = getResources().obtainTypedArray(R.array.listGameImage);
        String[] gameDescription = getResources().getStringArray(R.array.listGameDescription);

        ArrayList<Game> games = new ArrayList<>();

        for (int i = 0; i < gameName.length; i++){
            Game game = new Game();

            game.setName(gameName[i]);
            game.setGenre(gameGenre[i]);
            game.setPrice(gamePrice[i]);
            game.setImage(gameImage.getResourceId(i,-1));
            game.setDescription(gameDescription[i]);

            games.add(game);
        }

        return games;
    }
}