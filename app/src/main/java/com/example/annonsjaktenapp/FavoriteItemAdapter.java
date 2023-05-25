package com.example.annonsjaktenapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * En adapterklass för att binda favoritobjekt till en RecyclerView.
 */
public class FavoriteItemAdapter extends RecyclerView.Adapter<FavoriteItemAdapter.ViewHolder> {

    private final List<Product> favoriteProducts; // Modify this

    public FavoriteItemAdapter(List<Product> favoriteProducts) { // Modify this
        this.favoriteProducts = favoriteProducts; // Modify this
    }

    /**
     * Skapar och returnerar en ny ViewHolder för ett objekt i RecyclerView.
     *
     * @param parent   Föräldergruppen där ViewHolder kommer att placeras.
     * @param viewType Vyns typ.
     * @return En ny ViewHolder.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_favorite_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binder data från en favoritobjekt till en ViewHolder i RecyclerView.
     *
     * @param holder   ViewHolder att binda data till.
     * @param position Positionen för favoritobjektet i listan.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = favoriteProducts.get(position); // Modify this
        holder.titleView.setText(product.getTitle()); // Modify this
        holder.descriptionView.setText(product.getDescription()); // Modify this
        holder.imageView.setImageResource(product.getImageResId()); // Modify this
    }

    /**
     * Returnerar antalet favoritobjekt i listan.
     *
     * @return Antalet favoritobjekt.
     */
    @Override
    public int getItemCount() {
        return favoriteProducts.size(); // Modify this
    }

    /**
     * En ViewHolder som håller referenser till visningskomponenter för ett favoritobjekt.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        TextView descriptionView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.favorite_item_title);
            descriptionView = itemView.findViewById(R.id.favorite_item_description);
            imageView = itemView.findViewById(R.id.favorite_item_image);
        }
    }
}
