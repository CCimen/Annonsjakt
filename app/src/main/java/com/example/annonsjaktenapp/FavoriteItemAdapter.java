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

    private final List<FavoriteItem> favoriteItems; // En lista med favoritobjekt att visa i RecyclerView

    /**
     * Skapar en instans av FavoriteItemAdapter.
     *
     * @param favoriteItems En lista med favoritobjekt att visa.
     */
    public FavoriteItemAdapter(List<FavoriteItem> favoriteItems) {
        this.favoriteItems = favoriteItems;
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
        FavoriteItem item = favoriteItems.get(position);
        holder.titleView.setText(item.getTitle());
        holder.descriptionView.setText(item.getDescription());
        holder.imageView.setImageResource(item.getImageResId());
    }

    /**
     * Returnerar antalet favoritobjekt i listan.
     *
     * @return Antalet favoritobjekt.
     */
    @Override
    public int getItemCount() {
        return favoriteItems.size();
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
