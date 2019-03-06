package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.simplifiedcoding.bottomnavigationexample.Adapters.LocationAdapter;
import net.simplifiedcoding.bottomnavigationexample.Helper.DatabaseHelper;
import net.simplifiedcoding.bottomnavigationexample.Model.DataModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChangeAddress extends AppCompatActivity {
    TextView curraentlocation,addaddress;
    LocationAdapter locationAdapter;
    DatabaseHelper database;
    RecyclerView recyclerView;
    ArrayList<DataModel> datamodel;
    LinearLayoutManager linearLayoutManager;
    LinearLayout add_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);
         getIds();
         getAddessFromRecyclerview();

         add_address.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(ChangeAddress.this,AddAdress.class);
                 startActivity(intent);
             }
         });
    }
    public void getIds(){
        add_address=(LinearLayout)findViewById(R.id.add_address);
        recyclerView=findViewById(R.id.recyclelocation);
        curraentlocation=findViewById(R.id.currentlocation);
        addaddress=findViewById(R.id.addaddres);

    }
    public void  getAddessFromRecyclerview(){

        datamodel =new ArrayList<DataModel>();

        database = new DatabaseHelper(ChangeAddress.this);
        datamodel=  database.getdata();
        locationAdapter =new LocationAdapter(getApplication(),datamodel);

        LinearLayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(locationAdapter);
    }
}