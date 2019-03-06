package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.simplifiedcoding.bottomnavigationexample.Model.ParentModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.Viewholder> {
    Context context;
    ArrayList<ParentModel> parentModels;

    public ParentAdapter(Context context, ArrayList<ParentModel> parentModels) {
        this.context = context;
        this.parentModels = parentModels;
    }

    public  class Viewholder extends  RecyclerView.ViewHolder {
        protected RecyclerView recyclerView;
        protected    TextView textView;

        public Viewholder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.genre_headinga);
            recyclerView=itemView.findViewById(R.id.genre_inner_recycler);
        }
    }

    @Override
    public ParentAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.genere_unit,null);
        Viewholder mh = new Viewholder(view);
        return mh;

        //return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(ParentAdapter.Viewholder holder, int position) {
        ParentModel parentModel=parentModels.get(position);
        String a=parentModel.getName();
        holder.textView.setText(a);

        ArrayList arrayListchild=parentModel.getArrayList();

        ChildAdapter childAdapter=new ChildAdapter(context,arrayListchild);
        holder.recyclerView.setHasFixedSize(true);
       holder. recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(childAdapter);


    }

    @Override
    public int getItemCount() {
        return parentModels.size();
    }
}
