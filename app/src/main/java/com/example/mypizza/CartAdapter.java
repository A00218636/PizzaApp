package com.example.mypizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {


    Context context;
    //List of cart items
    List<CartModel> cart_list;

    public CartAdapter(Context context, List<CartModel> cart_list) {
        this.context = context;
        this.cart_list = cart_list;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cartitem,parent,false);

        return new ViewHolder(view);
    }

    //View holder function
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        if(cart_list!=null && cart_list.size()>0)
        {
            CartModel cartObj = cart_list.get(position);
            if (cartObj != null) {
                holder.deliveredBy_tv.setText(cartObj.getDeliveredBy());
                String amt = Double.toString(cartObj.netAmount);

                holder.amount_tv.setText(amt);
                holder.price_tv.setText(Double.toString(cartObj.price));

                holder.name_tv.setText(cartObj.getName());
                String pizCount = Integer.toString(cartObj.pizCount);
                holder.count_tv.setText(pizCount);
                String tax = Double.toString(cartObj.tax);
                holder.tax_tv.setText(tax);
            }




        }
        else{
            return;
        }
    }

    @Override
    public int getItemCount() {
        return cart_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView deliveredBy_tv, name_tv,price_tv, amount_tv, tax_tv, count_tv;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            name_tv =  itemView.findViewById(R.id.NameItem_tv);
            deliveredBy_tv =  itemView.findViewById(R.id.deliveredBy_tv);
            amount_tv =  itemView.findViewById(R.id.amountItem_tv);
            tax_tv = itemView.findViewById(R.id.taxItem_tv);
            price_tv = itemView.findViewById(R.id.PriceItem_tv);
            count_tv = (TextView) itemView.findViewById(R.id.countItem_tv);
        }
    }
}
