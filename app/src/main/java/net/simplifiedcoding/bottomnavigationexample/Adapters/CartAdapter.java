package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.Model.Cartmodel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.List;
import java.util.zip.Inflater;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {
RelativeLayout empty,show;
    Context context;
    List<Cartmodel> cartmodels;

    public CartAdapter(Context context, List<Cartmodel> cartmodels) {
        this.context = context;
        this.cartmodels = cartmodels;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name,item_quantity,item_cost;
        ImageView image;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.itemname);
            item_quantity=itemView.findViewById(R.id.itemquantity);
            item_cost=itemView.findViewById(R.id.itemcost);
            image=itemView.findViewById(R.id.image);


        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(context).inflate(R.layout.cart_items,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Cartmodel cartmodel=cartmodels.get(i);
        viewHolder.name.setText(cartmodel.getItemname());
        viewHolder.item_quantity.setText(cartmodel.getQuantity());
        viewHolder.item_cost.setText("Rs."+cartmodel.getCost());

        Picasso.with(context).load(cartmodel.getImage()).into(viewHolder.image);
    }
    @Override
    public int getItemCount() {
        return cartmodels.size();
    }
}
