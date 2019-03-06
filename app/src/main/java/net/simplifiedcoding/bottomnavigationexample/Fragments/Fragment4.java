package net.simplifiedcoding.bottomnavigationexample.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.simplifiedcoding.bottomnavigationexample.Adapters.Catogory_Adapter;
import net.simplifiedcoding.bottomnavigationexample.ListAdapter;
import net.simplifiedcoding.bottomnavigationexample.Model.Catogory_Items;
import net.simplifiedcoding.bottomnavigationexample.Pojo2;
import net.simplifiedcoding.bottomnavigationexample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {
    ListView list,list1;
    TextView more;
    List<Pojo2> pojo2List;
    Handler mHandler;


    public Fragment4() {
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


        View view=inflater.inflate(R.layout.fragment_subproducts1,container,false);
        list=view.findViewById(R.id.list);
        pojo2List = new ArrayList<>();
        JsonData();



        // Inflate the layout for this fragment
        return view;
    }

    private void JsonData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://graph.facebook.com/1935748656688922/feed?fields=id,name,story,created_time,message,full_picture&access_token=EAAfgaSbc6jUBADwe389RjY9GZAzy3t4Wm6q1WAokkHCbdZAJZB7I0QCYGJLdSrpSZBt8R3VgI4dnIgew5nmcg87gPrLXj7hLi5nzig4cVlZBI9CikDmHUUFXxlsQxHdZBFYCoZBAD516Fml7CWVuDon79GtNK3neW5Hm4j50ZAUyegZDZD", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getActivity(), ""+jsonObject, Toast.LENGTH_SHORT).show();
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        String id=jsonObject1.getString("id");
                        String created_time=jsonObject1.getString("created_time");

                        StringTokenizer stringTokenizer=new StringTokenizer(created_time,",");
                        String first=stringTokenizer.nextToken();
                        String second=stringTokenizer.nextToken();
                        first=first.substring(0,3);
                        second=second.substring(0,3);




                        String full_picture=jsonObject1.optString("full_picture");

                        // String full_picture1=jsonObject1.optString()
                        String message=jsonObject1.optString("message");
                        String name=jsonObject1.optString("name");
                        pojo2List.add(new Pojo2(id,created_time,name,message,full_picture));
                        ListAdapter listAdapter=new ListAdapter(getActivity(),pojo2List);
                        list.setAdapter(listAdapter);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        }
                //---------------------------------------------------------------------------------
        );

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }



}
