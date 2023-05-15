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
        PRODUCTS.add(new Product("Philips Rakapparat", "Philips shaver series 9000 cuts up to 20% more hair in a single stroke.", R.drawable.skonhetproduct5, 2, 2));
        PRODUCTS.add(new Product("Dior Homme Intense 100ml", "Dior Homme Intense 2011 by Dior is a Woody Floral Musk fragrance for men. Dior Homme Intense 2011 was launched in 2011.", R.drawable.skonhetproduct2, 2, 1));
        PRODUCTS.add(new Product("The Ordinary - Glycolic Acid 7% Toning Solution", "Glycolic Acid 7% Toning Solution is an exfoliant targeted at the surface of the skin. It helps improve skin clarity, balance uneven skin tone, and correct texture over time.  ", R.drawable.skonhetproduct3, 2, 3));
        PRODUCTS.add(new Product("La Roche-Posay Anthelios Uvmune Ultra Light Creme SPF 50+", "La Roche-Posay Anthelios UVmune Ultra Light Cream SPF50+ är en ansiktssolkräm för alla hudtyper. Formulan innehåller thermalskt vatten från La-Roche Posay.", R.drawable.skonhetproduct4, 2, 4));
        PRODUCTS.add(new Product("Dolce & Gabbana The One for Men Eau de Parfum Spray", "The One for Men Eau de Parfum is part of the iconic world of The One, offering a deeper fragrance experience for the perfume connoisseur.  Masculine and magnetic, this highly intense scent", R.drawable.skonhetproduct1, 2, 0));


        //Mobil Produkter
        PRODUCTS.add(new Product("OPPO Find X3 PRO", "Capture the colours of the world in their truest form with the revolutionary Find X3 Pro. Rich tones and deep hues combine to illuminate the road to the future.", R.drawable.mobilproduct11, 3, 0));
        PRODUCTS.add(new Product("Samsung Galaxy S23 Ultra SM-S918B 5G Dual SIM 8GB RAM", "Whether you’re headed to a concert or romantic night out, there’s no such thing as bad lighting with Night Mode; Galaxy S23 Ultra lets you capture epic content", R.drawable.mobilproduct2, 3, 1));
        PRODUCTS.add(new Product("OnePlus 11 5G | 16GB RAM+256GB | Dual-SIM | Titan Black", "The new Qualcomm Snapdragon 8 Gen 2 chipset is the most advanced chipset for Android devices, with increased CPU and GPU performance. Integrated AI processes improve background app usage", R.drawable.mobilproduct3, 3, 2));
        PRODUCTS.add(new Product("Google Pixel 7 Pro - 5G Android Phone - Unlocked Smartphone with Telephoto/Wide Angle Lens, and 24-Hour Battery - 128GB", "Google Pixel 7 Pro is Google’s best-of-everything phone; powered by Google Tensor G2, it’s faster, more efficient, and more secure", R.drawable.mobilproduct4, 3, 3));
        PRODUCTS.add(new Product("Nothing Phone 1 Smartphone Unlocked 5G Android Phone Snapdragon 778G+", " Behind the speed of Nothing Phone (1) is the Snapdragon 778G+ chipset. Cue phenomenal graphics. Enhanced gaming. Advanced camera functions. No charging head in the package.", R.drawable.mobilproduct5, 3, 4));

        //Kläder produkter
        PRODUCTS.add(new Product("Columbia Men's Glennaker Lake Rain Jacket", "WATERPROOF TECHNOLOGY: You’ll love our Columbia Men's Glennaker Lake Rain Jacket, it features our Hydroplus waterproof nylon fabric for the ultimate in lightweight, wet weather, protection and comfort.", R.drawable.kladerproduct1, 4, 0));
        PRODUCTS.add(new Product("MakeMeChic Women's Summer Boho Dress Floral Print ", "Feature: floral print, spaghetti strap, tie strap, square neck, cottagecore, sleeveless, knot shoulder, shirred, ruffle, a line, summer boho dress, maxi dress, vacation beach outfits for women, beach sun dress", R.drawable.kladerproduct2, 4, 1));
        PRODUCTS.add(new Product("Nike Men's Giannis Immortality White/Metallic Gold-Black", "Specially engineered Synthetic and mesh upper - delivers maximum breathability without looking meshy! Rubber TPU outsole - provides supreme traction where you need it", R.drawable.kladerproduct3, 4, 2));
        PRODUCTS.add(new Product("Nike Training Running Shoe, EU", "The Nike revolution 5 is made from recycled emp knit providing an athletic look Built for revolutionary comfort and responsiveness.", R.drawable.kladerproduct4, 4, 3));
        PRODUCTS.add(new Product("THE NORTH FACE Half Dome T-Shirt - Short-Sleeve - Men", "Not too big yet not too tight, this standard fit t-shirt skims the body while offering freedom of movement through the shoulders, chest and torso. Wear it tucked,", R.drawable.kladerproduct5, 4, 4));

        //Rekommenderad för dig produkter
        PRODUCTS.add(new Product("Adidas Shoe", "Adidas shoes are designed to deliver maximum comfort, performance and style.", R.drawable.kladerproduct4, 4, 3));




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
