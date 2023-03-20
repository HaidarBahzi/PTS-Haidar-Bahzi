package com.example.aplikasi_pts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.aplikasi_pts.databinding.ActivityDetailBinding;

public class ActivityDetail extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = new Intent(getIntent());

        String gameName = intent.getStringExtra("Name");
        String gameGenre = intent.getStringExtra("Genre");
        String gamePrice = intent.getStringExtra("Price");
        String gameDetail = intent.getStringExtra("Description");
//        String gameImageString = intent.getStringExtra("Poster");
        int gameImageConvert = intent.getIntExtra("Poster",R.drawable.ic_launcher_background);

        binding.gamePoster.setImageResource(gameImageConvert);
        binding.gameName.setText(gameName);
        binding.gameGenre.setText(gameGenre);
        binding.gamePrice.setText(gamePrice);
        binding.gameDescription.setText(gameDetail);

    }
}