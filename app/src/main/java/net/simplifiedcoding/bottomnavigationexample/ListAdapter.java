package net.simplifiedcoding.bottomnavigationexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context context;
    List<Pojo2> pojoList;



    public ListAdapter(Context context, List<Pojo2> pojoList) {
        this.context = context;
        this.pojoList = pojoList;
    }

    @Override
    public int getCount() {
        return pojoList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=LayoutInflater.from(context).inflate(R.layout.feed_layout,null);
        final TextView id,message,createdtime,tv_name;
        ImageView image;
        createdtime=view.findViewById(R.id.tv_time);
        message=view.findViewById(R.id.tv_message);
        tv_name=view.findViewById(R.id.tv_name);
        image=view.findViewById(R.id.imgView_proPic);

        final Pojo2 pojos=pojoList.get(position);
       createdtime.setText(pojos.getCreatedtime());
       tv_name.setText(pojos.getTv_name());
        message.setText(pojos.getMessage());
       // image.setText(pojos.getCreatedtime());
        if (pojos.getFullpicture().length()==0) {
            image.setImageResource(R.drawable.ic_vpn_key_black_24dp);
        } else {
            Picasso.with(context).load(pojos.getFullpicture()).into(image);

        }

       return  view;
    }
}
