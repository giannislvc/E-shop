package com.nativeboys.eshop.john2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nativeboys.eshop.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private List<Item> cData;
    private ClickListener itemClickListener;

    private List<Item> allItems;

    public ItemAdapter(Context context, List<Item> cData, ClickListener listener) {
        this.context = context;
        this.cData = cData;
        itemClickListener = listener;

        this.allItems = new ArrayList<>(cData);
    }

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder myViewHolder, int position) {

        myViewHolder.itemName.setText(cData.get(position).getName());
        myViewHolder.itemDescription.setText(cData.get(position).getDescription());
        myViewHolder.itemPrice.setText(cData.get(position).getPrice());
        myViewHolder.itemThumbnail.setImageResource(cData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {

        return cData.size();

    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Item> filteredList = new ArrayList<>();
            if (constraint.toString().isEmpty()) {
                filteredList.addAll(allItems);
            } else {
                for (Item item : allItems) {
                    if (item.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cData.clear();
            cData.addAll((Collection<? extends Item>) results.values);
            notifyDataSetChanged();
        }
    };


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView itemName;
        private TextView itemDescription;
        private TextView itemPrice;
        private ImageView itemThumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.row_detail_item_name);
            itemDescription = itemView.findViewById(R.id.row_detail_item_description);
            itemPrice = itemView.findViewById(R.id.row_detail_item_price);
            itemThumbnail = itemView.findViewById(R.id.row_detail_item_thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(cData.get(getAdapterPosition()), itemThumbnail);


                }
            });
        }
    }
}
