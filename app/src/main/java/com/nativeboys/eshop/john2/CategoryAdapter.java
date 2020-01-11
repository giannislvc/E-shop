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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    Context context;
    List<Category> cData;
    ClickListener clickListener;

    public CategoryAdapter(Context context, List<Category> cData, ClickListener listener) {
        this.context = context;
        this.cData = cData;
        clickListener = listener;
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder myViewHolder, int position) {

        myViewHolder.categoryName.setText(cData.get(position).getName());
        myViewHolder.categoryThumbnail.setImageResource(cData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return cData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryName;
        private ImageView categoryThumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_title);
            categoryThumbnail = itemView.findViewById(R.id.category_thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onCategoryClick(cData.get(getAdapterPosition()), categoryThumbnail);
                }
            });
        }
    }
}