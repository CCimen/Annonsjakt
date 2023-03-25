package com.example.annonsjaktenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class activity_favorite extends BaseActivity {

    private List<FavoriteItem> favoritedItems;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE);
        favoritedItems = getFavoritedItems();

        RecyclerView itemContainer = findViewById(R.id.favorite_item_container);
        itemContainer.setLayoutManager(new LinearLayoutManager(this));
        itemContainer.setAdapter(new FavoriteItemAdapter(favoritedItems));

        setUpBottomNavigation();
    }



    private List<FavoriteItem> getFavoritedItems() {
        Map<String, FavoriteItem> itemMap = new HashMap<>();
        String[] itemTitles = getResources().getStringArray(R.array.favorite_items);
        String[] itemDescriptions = getResources().getStringArray(R.array.favorite_items_description);
        int[] itemImages = getResources().getIntArray(R.array.favorite_item_images);

        for (int i = 1; i <= itemTitles.length; i++) {
            String itemKey = "item" + i;
            boolean isFavorite = sharedPreferences.getBoolean(itemKey, false);
            if (isFavorite) {
                String title = itemTitles[i - 1];
                String description = itemDescriptions[i - 1];
                int imageResId = itemImages[i - 1];
                FavoriteItem item = new FavoriteItem(title, description, imageResId);
                itemMap.put(itemKey, item);
            }
        }
        return new ArrayList<>(itemMap.values());
    }




    private static class FavoriteItem {
        private final String title;
        private final String description;
        private final int imageResId;

        private FavoriteItem(String title, String description, int imageResId) {
            this.title = title;
            this.description = description;
            this.imageResId = imageResId;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getImageResId() {
            return imageResId;
        }
    }

    private static class FavoriteItemAdapter extends RecyclerView.Adapter<FavoriteItemAdapter.ViewHolder> {

        private final List<FavoriteItem> favoriteItems;

        public FavoriteItemAdapter(List<FavoriteItem> favoriteItems) {
            this.favoriteItems = favoriteItems;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_favorite_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            FavoriteItem item = favoriteItems.get(position);
            holder.titleView.setText(item.getTitle());
            holder.descriptionView.setText(item.getDescription());
            holder.imageView.setImageResource(item.getImageResId());
        }



        @Override
        public int getItemCount() {
            return favoriteItems.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView titleView;
            TextView descriptionView;
            ImageView imageView;

            ViewHolder(View itemView) {
                super(itemView);
                titleView = itemView.findViewById(R.id.favorite_item_title);
                descriptionView = itemView.findViewById(R.id.favorite_item_description);
                imageView = itemView.findViewById(R.id.favorite_item_image);
            }
        }

    }
}

