package com.nativeboys.eshop.john2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nativeboys.eshop.R;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailActivity extends DialogFragment implements ClickListener{

    private final static String NAME="name";
    private final static String THUMBNAIL="thumbnail";


    private String categoryName;
    private TextView name;
    private RecyclerView recentRv;


    public static CategoryDetailActivity newInstance(String name, int thumbnail) {

        Bundle args = new Bundle();
        args.putString(NAME,name);
        args.putInt(THUMBNAIL,thumbnail);
        CategoryDetailActivity fragment = new CategoryDetailActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FadeFragmentTheme);
        if(getArguments() != null){
            categoryName = getArguments().getString(NAME);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_category_detail,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.detail_category_name);
        name.setText(categoryName);

        recentRv = view.findViewById(R.id.detail_category_rv);
        List<Item> recentItemsList = new ArrayList<>();
        recentItemsList.add(new Item("Bike","Lite used bike in nice condition","250.99",R.drawable.bike));
        recentItemsList.add(new Item("Hat","Beautiful hat for the sun","8.99",R.drawable.hat));
        recentItemsList.add(new Item("Pants","Large pant for large balls","20.40",R.drawable.pants));
        recentItemsList.add(new Item("Shoes","Expensive nike shoes for ur smelly feet","120.35",R.drawable.shoes));
        recentItemsList.add(new Item("T-Shirt","T-Shirt to cover your fat belly","12.99",R.drawable.shirt));
        recentItemsList.add(new Item("Bike","Lite used bike in nice condition","250.99",R.drawable.bike));
        recentItemsList.add(new Item("Hat","Beautiful hat for the sun","8.99",R.drawable.hat));
        recentItemsList.add(new Item("Pants","Large pant for large balls","20.40",R.drawable.pants));
        recentItemsList.add(new Item("Shoes","Expensive nike shoes for ur smelly feet","120.35",R.drawable.shoes));
        recentItemsList.add(new Item("T-Shirt","T-Shirt to cover your fat belly","12.99",R.drawable.shirt));
        ItemAdapter recentItemsAdapter  = new ItemAdapter(getContext(),recentItemsList,this);
        recentRv.setAdapter(recentItemsAdapter);
        recentRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onCategoryClick(Category category, ImageView categoryImageView) {

    }

    @Override
    public void onItemClick(Item item, ImageView itemImageView) {
        ItemDetailActivity.newInstance(item).show(getChildFragmentManager(), ItemDetailActivity.class.getSimpleName());
    }
}
