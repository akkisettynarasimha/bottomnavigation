package net.simplifiedcoding.bottomnavigationexample.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.simplifiedcoding.bottomnavigationexample.Adapters.OrderHistoryAdapter;
import net.simplifiedcoding.bottomnavigationexample.Model.OrderHistoryModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Belal on 1/23/2018.
 */

public class DashboardFragment extends Fragment {
    RecyclerView recyclerView;
    OrderHistoryAdapter orderHistoryAdapter;
    ArrayList<OrderHistoryModel>orderHistoryModels;
    GridLayoutManager gridLayoutManager;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.orderhistory);
        recyclerView.setHasFixedSize(true);

        gridLayoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
       orderHistoryModels=new ArrayList<>();
       orderHistoryModels.add(new OrderHistoryModel(R.drawable.men,"t-shirt for men blue color","deliver at 11-12-1019"));
        orderHistoryModels.add(new OrderHistoryModel(R.drawable.men,"t-shirt for men blue color","deliver at 11-12-1019"));
       orderHistoryAdapter=new OrderHistoryAdapter(getActivity(),orderHistoryModels);
       recyclerView.setAdapter(orderHistoryAdapter);

       return view;
    }
}
