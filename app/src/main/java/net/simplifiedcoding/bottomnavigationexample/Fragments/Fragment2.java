package net.simplifiedcoding.bottomnavigationexample.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.simplifiedcoding.bottomnavigationexample.Adapters.Catogory_Adapter;
import net.simplifiedcoding.bottomnavigationexample.Model.Catogory_Items;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    List<Catogory_Items> catogory_items;


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_subproducts,container,false);
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setHasFixedSize(true);
        catogory_items=new ArrayList<>();
        catogory_items.add(new Catogory_Items("caharn",R.drawable.a,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.c,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.b,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.a,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.a,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.b,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.b,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.c,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.c,"njnnjn"));
        catogory_items.add(new Catogory_Items("caharn",R.drawable.a,"njnnjn"));



        Catogory_Adapter catogory_adapter=new Catogory_Adapter(getActivity(),catogory_items);
        recyclerView.setAdapter(catogory_adapter);



        // Inflate the layout for this fragment
        return view;
    }


}
