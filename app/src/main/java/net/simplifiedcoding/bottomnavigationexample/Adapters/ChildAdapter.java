package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.Activity.ProductDiscreption;
import net.simplifiedcoding.bottomnavigationexample.Helper.CartSqlite;
import net.simplifiedcoding.bottomnavigationexample.Model.Child;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ChildAdapter   extends RecyclerView.Adapter<ChildAdapter.Viewholder> {
    Context context;
    ArrayList<Child> parentModels;
    CartSqlite cartSqlite;
    String Quantiy="1";
    public ChildAdapter(Context context, ArrayList<Child> parentModels) {
        this.context = context;
        this.parentModels = parentModels;
    }

    public  class Viewholder extends  RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView title,catoory,cost;
        ImageView imageView;
        LinearLayout addtocart,linear;
        public Viewholder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title1);
            catoory=itemView.findViewById(R.id.catagory);
            cost=itemView.findViewById(R.id.cost);
            addtocart=itemView.findViewById(R.id.addtocart);
            imageView=itemView.findViewById(R.id.thumbnail);
            linear=itemView.findViewById(R.id.linear);

        }
    }

    @Override
    public ChildAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.genere_inner_unit,null);

        return new ChildAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(final ChildAdapter.Viewholder holder, int position) {

        final Child parentModel=parentModels.get(position);
        holder.title.setText(parentModel.getName());
        holder.catoory.setText(parentModel.getCatagory());
        holder.cost.setText("Rs."+parentModel.getCost());
        holder.title.setText(parentModel.getName());
              Picasso.with(context).load(parentModel.getImage()).into(holder.imageView);
       // ArrayList arrayListchild=parentModel.arrayList;
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ProductDiscreption.class);
                context.startActivity(intent);
            }
        });
holder.addtocart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        cartSqlite=new CartSqlite(context);
        boolean resultt=cartSqlite.insertdata(parentModel.getName(),parentModel.getCost(),parentModel.getImage(),Quantiy);

        if (resultt==true)
        {
            Toast.makeText(context, "added successfull", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "not added ", Toast.LENGTH_SHORT).show();
        }
    }
});

    }

    @Override
    public int getItemCount() {
        return parentModels.size();
    }
}
