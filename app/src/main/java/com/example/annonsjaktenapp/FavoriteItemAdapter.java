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

    private final List<Product> favoriteProducts; // Lista över favoritobjekt

    public FavoriteItemAdapter(List<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
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
        Product product = favoriteProducts.get(position);
        holder.titleView.setText(product.getTitle());
        holder.descriptionView.setText(product.getDescription());
        holder.imageView.setImageResource(product.getImageResId());

        holder.unfavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition == RecyclerView.NO_POSITION) {
                    return;
                }

                Product currentProduct = favoriteProducts.get(currentPosition);
                currentProduct.setFavorite(false);
                FavoritesHolder.getInstance().removeFavorite(currentProduct);
                favoriteProducts.remove(currentPosition);
                notifyItemRemoved(currentPosition);
                notifyItemRangeChanged(currentPosition, favoriteProducts.size());
            }
        });
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

        ImageView unfavoriteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.favorite_item_title);
            descriptionView = itemView.findViewById(R.id.favorite_item_description);
            imageView = itemView.findViewById(R.id.favorite_item_image);
            unfavoriteButton = itemView.findViewById(R.id.unfavorite_button);
        }
    }
}
