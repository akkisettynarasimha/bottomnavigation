package net.simplifiedcoding.bottomnavigationexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Grepthor_3 on 12/29/2017.
 */

public class NextAdopter extends BaseAdapter {
    private Context context;
    private ArrayList<NextModel> models;

    public NextAdopter(Context context, ArrayList<NextModel> models) {
        this.context = context;
        this.models = models;
    }

    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get( i );
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){

            view = View.inflate(context, R.layout.item_next,null);
        }
        TextView tv1=(TextView)view.findViewById(R.id.textbank1);
        ImageView im1=(ImageView)view.findViewById( R.id.imagebank1);
        im1.getBackground();
      //  WebView webView = (WebView)view.findViewById( R.id.webdata );

        // getting all the class of Model
        NextModel model=models.get(i);

        // placeing every textview inside textview


       // Toast.makeText( context, "name"+model.getName(), Toast.LENGTH_SHORT ).show();
       // Toast.makeText( context, "Image url"+model.getImage(), Toast.LENGTH_SHORT ).show();
System.out.print("Image url"+ model.getImage());
        tv1.setText(model.getCardname());
      //  webView.loadUrl( "http://grepthorsoftware.in/tst/healthy/webservices/upload/FeeAndCharges.html" );

        if (model.getImm().equals("")) {
            Picasso.with(context)
                    .load(R.drawable.credit_card_icon)
                    .placeholder(R.drawable.credit_card_icon)
                    //    .resize(width, width)
                    .into(im1);

        } else {
            Picasso.with(context)
                    .load("http://arkainfoteck.xyz/helpmate/dynamic/assets/ns/"+model.getImm())
                    .placeholder(R.drawable.credit_card_icon)
                    //  .resize(width, width)
                    .into(im1);
        }


        return view;
    }
}
