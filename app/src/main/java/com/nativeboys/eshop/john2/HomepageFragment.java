package com.nativeboys.eshop.john2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nativeboys.eshop.R;

import java.util.ArrayList;
import java.util.List;

public class HomepageFragment extends Fragment implements ClickListener {

    private RecyclerView recentRv;
    private RecyclerView categoryRv;
    private RecyclerView favoriteRv;
    private RecyclerView mostViewsRv;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryRv = view.findViewById(R.id.category_rv);
        List<Category> lstCategory = new ArrayList<>();
        lstCategory.add(new Category("Clothes",R.mipmap.ic_launcher));
        lstCategory.add(new Category("Beauty & care",R.mipmap.ic_launcher));
        lstCategory.add(new Category("Phone & accessories",R.mipmap.ic_launcher));
        lstCategory.add(new Category("home",R.mipmap.ic_launcher));
        lstCategory.add(new Category("vehicle",R.mipmap.ic_launcher));
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(),lstCategory,this);
        categoryRv.setAdapter(categoryAdapter);
        categoryRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        recentRv = view.findViewById(R.id.recent_items_rv);
        List<Item> recentItemsList = new ArrayList<>();
        recentItemsList.add(new Item("Bike","Lite used bike in nice condition","250.99",R.drawable.bike));
        recentItemsList.add(new Item("Hat","Beautiful hat for the sun","8.99",R.drawable.hat));
        recentItemsList.add(new Item("Pants","Large pant for large balls","20.40",R.drawable.pants));
        recentItemsList.add(new Item("Shoes","Expensive nike shoes for ur smelly feet","120.35",R.drawable.shoes));
        recentItemsList.add(new Item("T-Shirt","T-Shirt to cover your fat belly","12.99",R.drawable.shirt));
        HomePageItemsAdapter homePageItemsAdapter = new HomePageItemsAdapter(getContext(),recentItemsList,this);
        recentRv.setAdapter(homePageItemsAdapter);
        recentRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        favoriteRv = view.findViewById(R.id.favorite_items_rv);
        List<Item> favoriteItemsList = new ArrayList<>();
        favoriteItemsList.add(new Item("Bike","Lite used bike in nice condition","250.99",R.drawable.bike));
        favoriteItemsList.add(new Item("Hat","Beautiful hat for the sun","8.99",R.drawable.hat));
        favoriteItemsList.add(new Item("Pants","Large pant for large balls","20.40",R.drawable.pants));
        favoriteItemsList.add(new Item("Shoes","Expensive nike shoes for ur smelly feet","120.35",R.drawable.shoes));
        favoriteItemsList.add(new Item("T-Shirt","T-Shirt to cover your fat belly","12.99",R.drawable.shirt));
        HomePageItemsAdapter favoriteItemsAdapter  = new HomePageItemsAdapter(getContext(),favoriteItemsList,this);
        favoriteRv.setAdapter(favoriteItemsAdapter);
        favoriteRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        mostViewsRv = view.findViewById(R.id.most_views_items_rv);
        List<Item> mostViewsItemsList = new ArrayList<>();
        mostViewsItemsList.add(new Item("Bike","Lite used bike in nice condition","250.99",R.drawable.bike));
        mostViewsItemsList.add(new Item("Hat","Beautiful hat for the sun","8.99",R.drawable.hat));
        mostViewsItemsList.add(new Item("Pants","Large pant for large balls","20.40",R.drawable.pants));
        mostViewsItemsList.add(new Item("Shoes","Expensive nike shoes for ur smelly feet","120.35",R.drawable.shoes));
        mostViewsItemsList.add(new Item("T-Shirt","T-Shirt to cover your fat belly","12.99",R.drawable.shirt));
        HomePageItemsAdapter mostViewsItemsAdapter  = new HomePageItemsAdapter(getContext(),recentItemsList,this);
        mostViewsRv.setAdapter(mostViewsItemsAdapter);
        mostViewsRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));



    }

    @Override
    public void onCategoryClick(Category category, ImageView categoryImageView) {
        CategoryDetailActivity.newInstance(category.getName(), category.getThumbnail())
                .show(getChildFragmentManager(), CategoryDetailActivity.class.getSimpleName());
    }

    @Override
    public void onItemClick(Item item, ImageView itemImageView) {
        ItemDetailActivity.newInstance(item).show(getChildFragmentManager(), ItemDetailActivity.class.getSimpleName());
    }
}
