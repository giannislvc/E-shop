package com.nativeboys.eshop.john2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nativeboys.eshop.R;

import java.util.List;

public class HomePageItemsAdapter extends RecyclerView.Adapter<HomePageItemsAdapter.MyViewHolder> {

    Context context;
    List<Item> iData;
    ClickListener listener;

    public HomePageItemsAdapter(Context context, List<Item> iData, ClickListener listener) {
        this.context = context;
        this.iData = iData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomePageItemsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_page_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageItemsAdapter.MyViewHolder myViewHolder, int position) {

        myViewHolder.itemName.setText(iData.get(position).getName());
        myViewHolder.itemPrice.setText(iData.get(position).getPrice());
        myViewHolder.itemThumbnail.setImageResource(iData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return iData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView itemName;
        private  TextView itemPrice;
        private ImageView itemThumbnail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.homepage_item_name);
            itemPrice = itemView.findViewById(R.id.homepage_item_price);
            itemThumbnail = itemView.findViewById(R.id.homepage_item_thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(iData.get(getAdapterPosition()),itemThumbnail);
                }
            });

        }
    }
}