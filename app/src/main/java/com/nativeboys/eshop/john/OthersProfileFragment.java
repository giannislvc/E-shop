package com.nativeboys.eshop.john;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nativeboys.eshop.R;
import com.nativeboys.eshop.john2.Category;
import com.nativeboys.eshop.john2.ClickListener;
import com.nativeboys.eshop.john2.Item;
import com.nativeboys.eshop.john2.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class OthersProfileFragment extends DialogFragment implements ClickListener {

    private RecyclerView productsRV;
    private List<Item> products;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FadeFragmentTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productsRV = view.findViewById(R.id.myProductsRV);
        products = new ArrayList<>();
        products.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        products.add(new Item("Hat", "Beautiful hat for the sun", "8.99", R.drawable.hat));
        products.add(new Item("Pants", "Large pant for large balls", "20.40", R.drawable.pants));
        products.add(new Item("Shoes", "Expensive nike shoes for ur smelly feet", "120.35", R.drawable.shoes));
        products.add(new Item("T-Shirt", "T-Shirt to cover your fat belly", "12.99", R.drawable.shirt));
        products.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        products.add(new Item("Hat", "Beautiful hat for the sun", "8.99", R.drawable.hat));
        products.add(new Item("Pants", "Large pant for large balls", "20.40", R.drawable.pants));
        products.add(new Item("Shoes", "Expensive nike shoes for ur smelly feet", "120.35", R.drawable.shoes));
        products.add(new Item("T-Shirt", "T-Shirt to cover your fat belly", "12.99", R.drawable.shirt));
        ItemAdapter myProductsAdapter = new ItemAdapter(getContext(), products, this);
        productsRV.setAdapter(myProductsAdapter);
        productsRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCategoryClick(Category category, ImageView categoryImageView) {

    }

    @Override
    public void onItemClick(Item item, ImageView itemImageView) {

    }

}
