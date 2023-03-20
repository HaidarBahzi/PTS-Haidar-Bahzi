package com.example.aplikasi_pts;

import static com.example.aplikasi_pts.R.layout.item_game;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private final ArrayList<Game> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewGame;
        private final TextView textViewGenre;
        private final TextView textViewPrice;
        private final ImageView imgViewGame;

    public ViewHolder(View view) {
        super(view);

        textViewGame = (TextView) view.findViewById(R.id.game_name);
        textViewGenre = (TextView) view.findViewById(R.id.game_genre);
        textViewPrice = (TextView) view.findViewById(R.id.game_price);
        imgViewGame = (ImageView) view.findViewById(R.id.game_image);

        }
    }

    public GameAdapter(ArrayList<Game> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(item_game, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        String gameName = localDataSet.get(position).getName();
        String gameGenre = localDataSet.get(position).getGenre();
        String gamePrice = localDataSet.get(position).getPrice();
        int gameImage = localDataSet.get(position).getImage();
        String gameDescription = localDataSet.get(position).getDescription();
        String gameImageConvert = String.valueOf(gameImage);


        viewHolder.textViewGame.setText(gameName);
        viewHolder.textViewGenre.setText(gameGenre);
        viewHolder.textViewPrice.setText(gamePrice);
        viewHolder.imgViewGame.setImageResource(gameImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), ActivityDetail.class);

                intent.putExtra("Poster", gameImage);
                intent.putExtra("Name", gameName);
                intent.putExtra("Genre", gameGenre);
                intent.putExtra("Price", gamePrice);
                intent.putExtra("Description", gameDescription);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
