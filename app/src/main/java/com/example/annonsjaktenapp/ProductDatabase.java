package com.example.annonsjaktenapp;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        //Dator produkter
        PRODUCTS.add(new Product("Sony Playstation 5 Console", "DualSense Wireless Controller integration: Feel your journey through the Norse realms, made possible by immersive haptic feedback and adaptive trigger functionality.", R.drawable.datorproduct1, 1, 0));
        PRODUCTS.add(new Product("Apple 2022 MacBook Air Laptop with M2 chip: 13.6-inch Liquid Retina Display, 8GB RAM, 256GB SSD Storage", "The redesigned MacBook Air is more portable than ever and weighs just 2.7 pounds.", R.drawable.datorproduct2, 1, 1));
        PRODUCTS.add(new Product("Apple Magic Mouse: Wireless, Bluetooth, Rechargeable. Works with Mac or iPad;", "Magic Mouse is wireless and rechargeable, with an optimized foot design that lets it glide smoothly across your desk.", R.drawable.datorproduct3, 1, 2));
        PRODUCTS.add(new Product("Apple AirPods Pro (2nd Generation) Wireless Earbuds", "Personalized Spatial Audio surrounds you in sound tuned just for you. It works with dynamic head tracking to immerse you deeper in music and movies.", R.drawable.datorproduct4, 1, 3));
        PRODUCTS.add(new Product("Apple Studio Display - Standard Glass - Tilt-Adjustable Stand", "An immersive 27-inch 5K Retina display with a 12MP camera with Center Stage, studio-quality mics, and six-speaker sound system.", R.drawable.datorproduct5, 1, 4));

        //Skönhet produkter
        PRODUCTS.add(new Product("Philips Rakapparat", "Philips shaver series 9000 cuts up to 20% more hair in a single stroke.", R.drawable.skonhetproduct5, 2, 0));
        PRODUCTS.add(new Product("Dior Homme Intense 100ml", "Dior Homme Intense 2011 by Dior is a Woody Floral Musk fragrance for men. Dior Homme Intense 2011 was launched in 2011.", R.drawable.skonhetproduct2, 2, 1));
        PRODUCTS.add(new Product("The Ordinary - Glycolic Acid 7% Toning Solution", "Glycolic Acid 7% Toning Solution is an exfoliant targeted at the surface of the skin. It helps improve skin clarity, balance uneven skin tone, and correct texture over time.  ", R.drawable.skonhetproduct3, 2, 2));
        PRODUCTS.add(new Product("La Roche-Posay Anthelios Uvmune Ultra Light Creme SPF 50+", "La Roche-Posay Anthelios UVmune Ultra Light Cream SPF50+ är en ansiktssolkräm för alla hudtyper. Formulan innehåller thermalskt vatten från La-Roche Posay.", R.drawable.skonhetproduct4, 2, 3));
        PRODUCTS.add(new Product("Dolce & Gabbana The One for Men Eau de Parfum Spray", "The One for Men Eau de Parfum is part of the iconic world of The One, offering a deeper fragrance experience for the perfume connoisseur.  Masculine and magnetic, this highly intense scent is a statement of charisma and sophistication.", R.drawable.skonhetproduct1, 2, 4));


        //Mobil Produkter
        PRODUCTS.add(new Product("Mobil 1 Titel", "Mobil 1 Beskrivning", R.drawable.mobilproduct1, 3, 0));
        PRODUCTS.add(new Product("Mobil 2 Titel", "Mobil 2 Beskrivning", R.drawable.mobilproduct2, 3, 1));
        PRODUCTS.add(new Product("Mobil 3 Titel", "Mobil 3 Beskrivning", R.drawable.mobilproduct3, 3, 2));
        PRODUCTS.add(new Product("Mobil 4 Titel", "Mobil 4 Beskrivning", R.drawable.mobilproduct4, 3, 3));
        PRODUCTS.add(new Product("Mobil 5 Titel", "Mobil 5 Beskrivning", R.drawable.mobilproduct5, 3, 4));

        //Kläder produkter
        PRODUCTS.add(new Product("Kläder 1 Titel", "Kläder 1 Beskrivning", R.drawable.kladerproduct1, 4, 0));
        PRODUCTS.add(new Product("Kläder 2 Titel", "Kläder 2 Beskrivning", R.drawable.kladerproduct2, 4, 1));
        PRODUCTS.add(new Product("Kläder 3 Titel", "Kläder 3 Beskrivning", R.drawable.kladerproduct3, 4, 2));
        PRODUCTS.add(new Product("Kläder 4 Titel", "Kläder 4 Beskrivning", R.drawable.kladerproduct4, 4, 3));
        PRODUCTS.add(new Product("Kläder 5 Titel", "Kläder 5 Beskrivning", R.drawable.kladerproduct5, 4, 4));

        //Rekommenderad för dig produkter
        PRODUCTS.add(new Product("Adidas Sko", "Adidas shoes are designed to deliver maximum comfort, performance and style.", R.drawable.kladerproduct4, 4, 3));




    }

    public static Product getProduct(int categoryId, int itemIndex) {
        for (Product product : PRODUCTS) {
            if (product.getCategoryId() == categoryId && product.getItemIndex() == itemIndex) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> getProducts(String query) {
        List<Product> products = new ArrayList<>();
        for (Product product : PRODUCTS) {
            if (product.getTitle().toLowerCase().contains(query.toLowerCase())) {
                products.add(product);
            }
        }
        return products;
    }

}
