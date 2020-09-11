package com.stackfloat.gads2020.services;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;


public class LoadImageWithPicasso {
    private LoadImageWithPicasso(){}

    /**
     * gradle plugin=implementation 'com.squareup.picasso:picasso:2.5.2'
     *
     * this method loads image into an ImageView
     *
     * @param view @ImageView to load the image into
     * @param imageUrl url of the image to be loaded
     * @param resourceId ResourceId of a placeHolder image that will
     *                   also act as a fallback if a book has no cover image
     */
    public static void loadImage(@NonNull ImageView view,
                                 String imageUrl,
                                @NonNull Integer resourceId){
        if (imageUrl==null || imageUrl.equals("")) {
            view.setImageResource(resourceId);
        }else {
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(resourceId)
                    .into(view);
        }
    }
}
