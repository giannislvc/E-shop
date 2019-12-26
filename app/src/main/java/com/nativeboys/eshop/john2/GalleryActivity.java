package com.nativeboys.eshop.john2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.nativeboys.eshop.R;

import static com.nativeboys.eshop.john2.ItemDetailActivity.ITEM;

public class GalleryActivity extends DialogFragment {

    private Item item;
    private ImageView thumbnail;
    private ViewPager viewPager;

    public static GalleryActivity newInstance(Item item) {

        Bundle args = new Bundle();
        args.putParcelable(ITEM, item);
        GalleryActivity fragment = new GalleryActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            item = getArguments().getParcelable(ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_gallery,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPager);
        GalleryAdapter adapter = new GalleryAdapter(viewPager.getContext());
        viewPager.setAdapter(adapter);
        thumbnail = view.findViewById(R.id.imageView);

        if (item != null){
            thumbnail.setImageResource(item.getThumbnail());
        }
    }
}



