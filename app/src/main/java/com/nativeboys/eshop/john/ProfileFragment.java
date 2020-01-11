package com.nativeboys.eshop.john;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nativeboys.eshop.R;
import com.nativeboys.eshop.john2.Category;
import com.nativeboys.eshop.john2.ClickListener;
import com.nativeboys.eshop.john2.Item;
import com.nativeboys.eshop.john2.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends DialogFragment implements ClickListener{

    private RecyclerView myProductsRV;
    private FloatingActionButton addItemButton;
    private Button editProfileButton;
    private FloatingActionButton settingsButton;
    private List<Item> myProducts;

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

        settingsButton = view.findViewById(R.id.settingsFab);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SettingsActivity().show(getChildFragmentManager(), SettingsActivity.class.getSimpleName());
            }
        });

        addItemButton = view.findViewById(R.id.addItemFab);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddItemActivity().show(getChildFragmentManager(), AddItemActivity.class.getSimpleName());
            }
        });

        editProfileButton = view.findViewById(R.id.edit_profile_button);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EditProfileActivity().show(getChildFragmentManager(), EditProfileActivity.class.getSimpleName());
            }
        });

    }

    @Override
    public void onCategoryClick(Category category, ImageView categoryImageView) {

    }

    @Override
    public void onItemClick(Item item, ImageView itemImageView) {
        EditItemActivity.newInstance(item).show(getChildFragmentManager(), EditItemActivity.class.getSimpleName());
    }
}
