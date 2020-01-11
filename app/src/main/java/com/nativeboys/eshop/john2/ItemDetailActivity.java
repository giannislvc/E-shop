package com.nativeboys.eshop.john2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nativeboys.eshop.R;

public class ItemDetailActivity extends DialogFragment {

    public final static String ITEM = "item";
    private Item item;
    private ToggleButton toggleButton;
    private TextView name;
    private TextView description;
    private TextView price;
    private ImageView thumbnail;
    private Button visitProfile;
    private Button contactSeller;
    private RatingBar ratingBar;

    public static ItemDetailActivity newInstance(Item item) {
        Bundle args = new Bundle();
        args.putParcelable(ITEM, item);
        ItemDetailActivity fragment = new ItemDetailActivity();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FadeFragmentTheme);
        if (getArguments() != null) {
            item = getArguments().getParcelable(ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_item_detail_version_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.detail_item_name);
        description = view.findViewById(R.id.detail_item_description);
        price = view.findViewById(R.id.detail_item_price);
        thumbnail = view.findViewById(R.id.detail_item_thumbnail);
        visitProfile = view.findViewById(R.id.detail_item_visit_profile_button);
        toggleButton = view.findViewById(R.id.favorite_toggle_btn);
        ratingBar = view.findViewById(R.id.item_rating_bar);


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    //add item to favorite list
                } else {
                    //remove item from favorite list
                }
            }
        });

        //sundesh me to chat
        contactSeller = view.findViewById(R.id.detail_item_contact_button);

        //allagh constractor kai adapter gia na stelnoume kai to onoma tou seller
        visitProfile.setText("Visite " + "\"Sellers name\"");

        if (item != null) {
            name.setText(item.getName());
            description.setText(item.getDescription());
            price.setText(item.getPrice());
            thumbnail.setImageResource(item.getThumbnail());
        }

        thumbnail.setOnClickListener((View v) -> {
            GalleryActivity.newInstance(item).show(getChildFragmentManager(), GalleryActivity.class.getSimpleName());
        });


    }
}
