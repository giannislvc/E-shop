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
import com.nativeboys.eshop.john2.ItemDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MyFavoritesFragment extends Fragment implements ClickListener {

    private List<Item> myProducts;
    private RecyclerView myProductsRV;
    private View view;

    public MyFavoritesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_favorites_fragment, container, false);
        myProductsRV = view.findViewById(R.id.myFavoritesRV);
        myProducts = new ArrayList<>();
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
        myProducts.add(new Item("Bike", "Lite used bike in nice condition", "250.99", R.drawable.bike));
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
        ItemDetailActivity.newInstance(item).show(getChildFragmentManager(), ItemDetailActivity.class.getSimpleName());
    }
}
