package net.simplifiedcoding.bottomnavigationexample.Adapters;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.bottomnavigationexample.Model.ProductDiscreptionModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ProductDiscreptionAdopter extends RecyclerView.Adapter<ProductDiscreptionAdopter.ViewHolder> {
    Context context;
    ArrayList<ProductDiscreptionModel> jobHistoryModels;

    public ProductDiscreptionAdopter(Context context, ArrayList<ProductDiscreptionModel> jobHistoryModels) {
        this.context = context;
        this.jobHistoryModels = jobHistoryModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.productdiscreptionitems,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ProductDiscreptionModel jobHistoryModel=jobHistoryModels.get(i);
        viewHolder.product.setText(jobHistoryModel.getProduct());
        viewHolder.productname.setText(jobHistoryModel.getProductname());


    }

    @Override
    public int getItemCount() {
        return jobHistoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView product,productname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product=itemView.findViewById(R.id.product);
            productname=itemView.findViewById(R.id.productname);


        }
    }
}
