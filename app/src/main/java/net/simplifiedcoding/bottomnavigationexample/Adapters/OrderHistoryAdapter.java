package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.bottomnavigationexample.Activity.OderHistoryViewDetails;
import net.simplifiedcoding.bottomnavigationexample.Model.OrderHistoryModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {
    Context context;
    ArrayList<OrderHistoryModel> orderHistoryModels;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String pname1, type;

    public OrderHistoryAdapter(Context context, ArrayList<OrderHistoryModel> orderHistoryModels) {
        this.context = context;
        this.orderHistoryModels = orderHistoryModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.orderhistoryadpter, viewGroup, false);
        return new ViewHolder(view, context, orderHistoryModels);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        OrderHistoryModel orderHistoryModel = orderHistoryModels.get(i);
        viewHolder.productimage.setImageResource(orderHistoryModel.getImage());
        viewHolder.Productname.setText(orderHistoryModel.getProductname());
        viewHolder.delivery.setText(orderHistoryModel.getDelivery());
    }

    @Override
    public int getItemCount() {

        return orderHistoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        List<OrderHistoryModel> orderHistoryModels;
        TextView Productname,delivery;
        ImageView productimage;

        public ViewHolder(@NonNull View itemView, Context context, List<OrderHistoryModel> orderHistoryModels) {
            super(itemView);
            this.context = context;
            this.orderHistoryModels = orderHistoryModels;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            productimage=itemView.findViewById(R.id.productimagename);
            Productname=itemView.findViewById(R.id.productname);
            delivery=itemView.findViewById(R.id.delivery);




        }

        @Override
        public void onClick(View v) {
           /* int position = getAdapterPosition();

            Intent intent = new Intent(this.context, OrderHistory.class);
            sharedPreferences = context.getSharedPreferences("bookingid", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            int i = getAdapterPosition();
            JobHistoryModel jobHistoryModel = jobHistoryModels.get(i);
            pname1 = jobHistoryModel.getMaid_book_id();
            type = jobHistoryModel.getType();
            editor.putString("booking", pname1);
            editor.putString("type", type);
            editor.apply();
            editor.commit();
            System.out.print("asdfbgg" + pname1);

            this.context.startActivity(intent);*/
            Intent intent = new Intent(this.context, OderHistoryViewDetails.class);
            this.context.startActivity(intent);



        }
    }
}