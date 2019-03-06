package net.simplifiedcoding.bottomnavigationexample.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import net.simplifiedcoding.bottomnavigationexample.Adapters.MyCustomPagerAdapter;
import net.simplifiedcoding.bottomnavigationexample.Adapters.ParentAdapter;
import net.simplifiedcoding.bottomnavigationexample.Model.Child;
import net.simplifiedcoding.bottomnavigationexample.Model.PagerModel;
import net.simplifiedcoding.bottomnavigationexample.Model.ParentModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Belal on 1/23/2018.
 */

public class HomeFragment extends Fragment {
    private RecyclerView mGenreRecycler;
    ;  private ArrayList<PagerModel> pagerModelArrayList;
    private MyCustomPagerAdapter myCustomPagerAdapter;
    Timer timer;
    DotsIndicator dotsIndicator;

    ArrayList<ParentModel> parentModels;
    private ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        parentModels = new ArrayList<ParentModel>();
        mGenreRecycler = view.findViewById(R.id.genre_recycler);
        pager = (ViewPager)view. findViewById(R.id.pager);
        dotsIndicator = (DotsIndicator) view.findViewById(R.id.dots_indicator);
        mGenreRecycler.setHasFixedSize(true);
        mGenreRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ParentAdapter parentAdapter = new ParentAdapter(getActivity(), parentModels);
        mGenreRecycler.setAdapter(parentAdapter);
        pagerModelArrayList=new ArrayList<>();
        createDummyData();
        pagerReq();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                pager.post(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            pager.setCurrentItem((pager.getCurrentItem() + 1) % pagerModelArrayList.size());
                        }
                        catch (Exception e){

                        }

                    }
                });

            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 3000, 3000);

        return view;
    }

    private void pagerReq() {

        RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "http://www.jirvi.com/restapi/banners.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            System.out.println("Data:"+response);

                            JSONObject jsonObject= new JSONObject(response);
                            // System.out.println("Result1 :" + jsonArray);
                            // JSONObject jsonObject=jsonArray.getJSONObject(0);

                            JSONArray jsonArray1=jsonObject.getJSONArray("banner_details");


                            for(int i=0;i<jsonArray1.length();i++)
                            {
                                JSONObject jsonObj1 = jsonArray1.getJSONObject(i);

                                String image     = jsonObj1.getString("url");

                                pagerModelArrayList.add( new PagerModel(image) );
                            }

                            myCustomPagerAdapter = new MyCustomPagerAdapter(getActivity(),pagerModelArrayList);
                            pager.setAdapter(myCustomPagerAdapter);
                            dotsIndicator.setViewPager(pager);
                        }catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    };
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {
                // TODO Auto-generated method stub
            };
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("d","25");
                return params;
            }
        });
        rq.add(stringRequest);

    }

    private void createDummyData() {
StringRequest stringRequest=new StringRequest(Request.Method.GET, "http://www.jirvi.com/restapi/homeblocks.php", new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);

            JSONObject jsonObject1=jsonObject.getJSONObject("home_blocks");

            JSONObject blocks_data=jsonObject1.getJSONObject("blocks_data");
            JSONObject block_products_data=jsonObject1.getJSONObject("block_products_data");





            for (int i=0;i<block_products_data.length();i++)
            {
                JSONObject jsonObject2=blocks_data.getJSONObject("");
            }












        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

    }
});
RequestQueue requestQueue=Volley.newRequestQueue(getActivity());
requestQueue.add(stringRequest);

        for (int i = 0; i < 5; i++) {
            // JSONObject jsonObjectz = jsonObject1.getJSONObject(String.valueOf(i));

            // String namee=jsonObjectz.getString("title");
            // Toast.makeText(MainActivity.this, ""+namee, Toast.LENGTH_SHORT).show();
            ParentModel dm = new ParentModel();

            dm.setName("Section " + i);

            ArrayList<Child> singleItem = new ArrayList<Child>();

                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));
                singleItem.add(new Child("Item ", "https://4.imimg.com/data4/VU/YD/ANDROID-28787331/product-500x500.jpeg", "nale", "40"));

                dm.setArrayList(singleItem);
            parentModels.add(dm);


        }
    }
}
