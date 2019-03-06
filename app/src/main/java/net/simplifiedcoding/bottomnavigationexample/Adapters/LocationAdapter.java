package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import net.simplifiedcoding.bottomnavigationexample.Model.DataModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    Context context;
    ArrayList<DataModel> dataModels;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public LocationAdapter(Context context, ArrayList<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.address_location,viewGroup,false);
        return new LocationAdapter.ViewHolder(view,context,dataModels);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DataModel dataModel=dataModels.get(i);
        viewHolder.place_delivary.setText(dataModel.getCity());
        viewHolder.delivary_address.setText(dataModel.getHouse());

    }

    @Override
    public int getItemCount() {
        return  dataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView place_delivary,delivary_address;
        Context context;
        ArrayList<DataModel> dataModels;

        public ViewHolder(@NonNull View itemView, Context context, ArrayList<DataModel> dataModels) {
            super(itemView);
            this.context=context;
            this.dataModels=dataModels;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

            place_delivary=(TextView)itemView.findViewById(R.id.place_delivary);
            delivary_address=(TextView)itemView.findViewById(R.id.delivary_address);

        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            DataModel modelMilk=this.dataModels.get(position);
            Intent intent=new Intent(this.context, Address.class);


            sharedPreferences=context.getSharedPreferences("AddressDetails",Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("completeaddress",modelMilk.getCity());
            editor.commit();
            editor.apply();

            this.context.startActivity(intent);


        }

    }
 }