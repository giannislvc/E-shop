package com.nativeboys.eshop.john;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nativeboys.eshop.R;

public class ProfileFragment extends DialogFragment {

    //profile items list example

    ListView listView;
    String mTitle[] = {"Bike", "Hat", "Pant", "Shoes", "T-Shirt"};
    String mPrice[] = {"250.99","8.99","20.40","120.35","12.99"};
    String mDescription[] = {"Lite used bike in nice condition", "Beautifull hat for the sun", "Large pant for large balls", "expensive nike shoes for ur smelly feet", "T-Shirt to cover your fat belly"};
    int images[] = {R.drawable.bike, R.drawable.hat, R.drawable.pants, R.drawable.shoes, R.drawable.shirt};

    private FloatingActionButton addItemButton;
    private Button editProfileButton;

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

        listView = view.findViewById(R.id.listView);


        // List adapter

        ProfileListItemAdapter adapter = new ProfileListItemAdapter(getContext(), mTitle, mPrice, mDescription, images);
        listView.setAdapter(adapter);

        //list item onclick

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new EditItemActivity().show(getChildFragmentManager(), EditItemActivity.class.getSimpleName());

            }
        });

    }



    class ProfileListItemAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rPrice[];
        String rDescription[];
        int rImgs[];

        ProfileListItemAdapter(Context c, String title[], String price[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.title, title);
            this.context = c;
            this.rTitle = title;
            this.rPrice = price;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.title);
            TextView myPrice = row.findViewById(R.id.priceTextView);
            TextView myDescription = row.findViewById(R.id.item_description);

            //set resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myPrice.setText(rPrice[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }



}
