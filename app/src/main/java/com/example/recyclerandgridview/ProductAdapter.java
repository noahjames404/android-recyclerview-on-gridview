package com.example.recyclerandgridview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<Product> products;
    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView price, description, name;
        public LinearLayout linearLayout;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            price = (TextView) itemView.findViewById(R.id.tvPrice);
            name = (TextView) itemView.findViewById(R.id.tvName);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.product_item);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //trigger
                    Log.d("user_click", "onClick: item clicked item" + name.getText());
                }
            });
        }
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list,parent,false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        Product product = products.get(position);
        holder.name.setText(product.name);
        holder.price.setText(product.price);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
