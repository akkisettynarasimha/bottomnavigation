package net.simplifiedcoding.bottomnavigationexample.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import net.simplifiedcoding.bottomnavigationexample.Activity.Catogory_DashBoad;
import net.simplifiedcoding.bottomnavigationexample.Model.Expandlist;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ExpandAdapter extends BaseAdapter {
    Context context;
    TextView t7;

    private ArrayList<Expandlist> installments;

    public ExpandAdapter(Context context, ArrayList<Expandlist> models) {
        this.context = context;
        this.installments = models;
    }

    @Override
    public int getCount() {
        return installments.size();
    }

    @Override
    public Object getItem(int position) {
        return installments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            convertView = View.inflate(context, R.layout.expandlayout, null);
        }

        t7 = (TextView) convertView.findViewById(R.id.mtitle);

        final Expandlist model = installments.get(position);
        t7.setText(model.getExpand());

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+model.getExpand(), Toast.LENGTH_SHORT).show();
                int pos = (Integer) view.getId();
                Intent i = new Intent(context, Catogory_DashBoad.class);
                context.startActivity(i);
            }
        });



        return convertView;
    }

    private void openDetailActivity(String... details) {
//        Intent i = new Intent(context, MainActivity2.class);
//        context.startActivity(i);
    }
}



