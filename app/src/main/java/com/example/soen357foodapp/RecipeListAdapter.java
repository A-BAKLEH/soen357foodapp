package com.example.soen357foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * David-Salomon Dahan
 * Filename: RecipeListAdapter.java
 * Creation: 2022-11-24
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {
    private ArrayList<RecipeModel> recipes;
    private Context context;

    public RecipeListAdapter(ArrayList<RecipeModel> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_card, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        RecipeModel recipe = recipes.get(position);

        holder.imageView.setImageResource(R.drawable.crevettes);
        holder.titleTextView.setText(recipe.rname);
        holder.ratingTextView.setText(String.format("Rating: %d", recipe.rating));
        holder.timeRequiredTextView.setText(String.format("%d min", recipe.timeRequired));
        holder.difficultyTextView.setText(String.format("Level %d", recipe.difficulty));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView ratingTextView;
        public TextView timeRequiredTextView;
        public TextView difficultyTextView;



        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            ratingTextView = (TextView) itemView.findViewById(R.id.ratingTextView);
            timeRequiredTextView = (TextView) itemView.findViewById(R.id.timeRequiredTextView);
            difficultyTextView = (TextView) itemView.findViewById(R.id.difficultyTextView);
        }
    }
}
