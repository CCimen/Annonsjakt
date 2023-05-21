package com.example.annonsjaktenapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class ProductDataFetchUtil {

    /**
     * Fetches data for products in a specific category.
     *
     * @param context   the context
     * @param categoryId the category ID
     * @return a list of products in the category
     */
    public List<Product> fetchProductData(Context context, int categoryId) {
        List<Product> products = new ArrayList<>();

        Resources res = context.getResources();
        String categoryPrefix = "category_" + categoryId;

        String[] productTitles = res.getStringArray(res.getIdentifier(categoryPrefix + "_titles", "array", context.getPackageName()));
        TypedArray productImages = res.obtainTypedArray(res.getIdentifier(categoryPrefix + "_images", "array", context.getPackageName()));
        String[] productDescriptions = res.getStringArray(res.getIdentifier(categoryPrefix + "_descriptions", "array", context.getPackageName())); // Get the descriptions array
        String[] productPrices = res.getStringArray(res.getIdentifier(categoryPrefix + "_prices", "array", context.getPackageName()));
        String[] productSellers = res.getStringArray(res.getIdentifier(categoryPrefix + "_sellers", "array", context.getPackageName()));

        for (int i = 0; i < productTitles.length; i++) {
            Product product = new Product(productTitles[i], productDescriptions[i], productImages.getResourceId(i, -1), categoryId, i, productPrices[i], productSellers[i]);
            products.add(product);
        }

        productImages.recycle(); // Do not forget to recycle the TypedArray once you are done with it

        return products;
    }



}
