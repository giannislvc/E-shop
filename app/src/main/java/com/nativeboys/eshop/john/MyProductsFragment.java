package com.nativeboys.eshop.john;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nativeboys.eshop.R;
import com.nativeboys.eshop.john2.Category;
import com.nativeboys.eshop.john2.ClickListener;
import com.nativeboys.eshop.john2.Item;
import com.nativeboys.eshop.john2.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyProductsFragment extends Fragment implements ClickListener {
    private List<Item> myProducts;
    private RecyclerView myProductsRV;
    private View view;

    public MyProductsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_products_fragment,container,false);
        myProductsRV = view.findViewById(R.id.myProductsRV);
        myProducts = new ArrayList<>();
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Hat", "Beautiful hat for the sun", "8.99", R.drawable.hat));
        myProducts.add(new Item("Pants", "Large pant for large balls", "20.40", R.drawable.pants));
        myProducts.add(new Item("Shoes", "Expensive nike shoes for ur smelly feet", "120.35", R.drawable.shoes));
        myProducts.add(new Item("T-Shirt", "T-Shirt to cover your fat belly", "12.99", R.drawable.shirt));
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Hat", "Beautiful hat for the sun", "8.99", R.drawable.hat));
        myProducts.add(new Item("Pants", "Large pant for large balls", "20.40", R.drawable.pants));
        myProducts.add(new Item("Shoes", "Expensive nike shoes for ur smelly feet", "120.35", R.drawable.shoes));
        myProducts.add(new Item("T-Shirt", "T-Shirt to cover your fat belly", "12.99", R.drawable.shirt));
        ItemAdapter myProductsAdapter = new ItemAdapter(getContext(), myProducts, this);
        myProductsRV.setAdapter(myProductsAdapter);
        myProductsRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void onCategoryClick(Category category, ImageView categoryImageView) {

    }

    @Override
    public void onItemClick(Item item, ImageView itemImageView) {
        EditItemActivity.newInstance(item).show(getChildFragmentManager(), EditItemActivity.class.getSimpleName());
    }
}
