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
        return fetchProductData(context, categoryId, true, true, true);
    }

    /**
     * Fetches data for products in a specific category, filtered by seller.
     *
     * @param context   the context
     * @param categoryId the category ID
     * @param blocket   include Blocket products in the result
     * @param tradera   include Tradera products in the result
     * @param sellpy      include eBay products in the result
     * @return a list of filtered products in the category
     */
    public List<Product> fetchProductData(Context context, int categoryId, boolean blocket, boolean tradera, boolean sellpy) {
        List<Product> products = new ArrayList<>();

        Resources res = context.getResources();
        String categoryPrefix = "category_" + categoryId;

        String[] productTitles = res.getStringArray(res.getIdentifier(categoryPrefix + "_titles", "array", context.getPackageName()));
        TypedArray productImages = res.obtainTypedArray(res.getIdentifier(categoryPrefix + "_images", "array", context.getPackageName()));
        String[] productDescriptions = res.getStringArray(res.getIdentifier(categoryPrefix + "_descriptions", "array", context.getPackageName())); // Get the descriptions array
        String[] productPrices = res.getStringArray(res.getIdentifier(categoryPrefix + "_prices", "array", context.getPackageName()));
        String[] productSellers = res.getStringArray(res.getIdentifier(categoryPrefix + "_sellers", "array", context.getPackageName()));

        for (int i = 0; i < productTitles.length; i++) {
            // Check the seller and add to the list only if it matches the filter
            if ((productSellers[i].equals("Blocket") && blocket) || (productSellers[i].equals("Tradera") && tradera) || (productSellers[i].equals("Sellpy") && sellpy)) {
                Product product = new Product(productTitles[i], productDescriptions[i], productImages.getResourceId(i, -1), categoryId, i, productPrices[i], productSellers[i], false);
                products.add(product);
            }
        }

        productImages.recycle();

        return products;
    }
}
