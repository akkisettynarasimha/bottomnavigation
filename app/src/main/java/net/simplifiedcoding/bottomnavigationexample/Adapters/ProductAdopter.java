package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import net.simplifiedcoding.bottomnavigationexample.Model.ProductModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ProductAdopter extends RecyclerView.Adapter<ProductAdopter.MyView> {
    Context context;
    ArrayList<ProductModel>productModels;

    public ProductAdopter(Context context, ArrayList<ProductModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
       View view =layoutInflater.inflate(R.layout.project_items,viewGroup,false);
        return new MyView(view,context,productModels);
    }
    @Override
    public void onBindViewHolder(@NonNull MyView myView, int i) {

    }
    @Override
    public int getItemCount()
    {
        return productModels.size();
    }

    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener{
        ArrayList<ProductModel>productModels;
        Context context;
        public MyView(@NonNull View itemView,Context context,ArrayList<ProductModel>productModels) {
            super(itemView);

            this.context=context;
            this.productModels=productModels;

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
       //     Intent intent=new Intent(this.context, DashBoard.class);

        }
    }
}
