package com.example.annonsjaktenapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/**
 * En adapterklass för att hantera visning av produkter i en RecyclerView.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public final List<Product> productList; // Lista över produkter
    private final LayoutInflater inflater; // Layoutinflator för att skapa visningar

    /**
     * Skapar en ny instans av ProductAdapter.
     *
     * @param context      Kontexten för aktiviteten eller fragmentet.
     * @param productList Listan över produkter att visas.
     */
    public ProductAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.title.setText(product.getTitle());
        holder.description.setText(product.getDescription());
        holder.image.setImageResource(product.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), item_detailsActivity.class);
            intent.putExtra("product", product);
            v.getContext().startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    /**
     * En viewholder för att hålla referenser till visningskomponenter i varje produktobjekt.
     */
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        final TextView title; // Textvy för produkttitel
        final TextView description; // Textvy för produktbeskrivning
        final ImageView image; // Bildvy för produktbild

        public ProductViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.product_title);
            description = itemView.findViewById(R.id.product_description);
            image = itemView.findViewById(R.id.product_image);
        }
    }
}