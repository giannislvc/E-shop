package com.nativeboys.eshop.john2;

import android.widget.ImageView;

public interface ClickListener {

    void onCategoryClick(Category category, ImageView categoryImageView);
    void onItemClick(Item item, ImageView itemImageView);

}
