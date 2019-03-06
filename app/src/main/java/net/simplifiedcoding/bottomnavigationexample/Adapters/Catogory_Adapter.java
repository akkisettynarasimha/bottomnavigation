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

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.Activity.ProductDiscreption;
import net.simplifiedcoding.bottomnavigationexample.Model.Catogory_Items;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class Catogory_Adapter extends RecyclerView.Adapter<Catogory_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Catogory_Items> albumList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public LinearLayout linear;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title1);

           thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            linear = (LinearLayout) view.findViewById(R.id.linear);

        }
    }
    public Catogory_Adapter(Context mContext, List<Catogory_Items> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subcatogory_album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Catogory_Items album = albumList.get(position);
        holder.title.setText(album.getName());
     //   holder.count.setText(album.getNumOfSongs() + " songs");

        // loading album cover using Glide library
        Picasso.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,ProductDiscreption.class);
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
