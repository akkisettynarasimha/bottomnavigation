package net.simplifiedcoding.bottomnavigationexample.creditcardproductsba;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.simplifiedcoding.bottomnavigationexample.NextAdopter;
import net.simplifiedcoding.bottomnavigationexample.NextModel;
import net.simplifiedcoding.bottomnavigationexample.R;
import net.simplifiedcoding.bottomnavigationexample.SharedPreferenceManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grepthor_3 on 1/3/2018.
 */

public class FragmentChild extends Fragment {
    String childname;
    Bundle bundle;
    String cardname,imageUrl,imageback,approvalTime,annualFee,renewalFee,webdata;
    Intent inin;
    TextView textViewChildName;

    private ArrayList<NextModel> models;
    private NextAdopter moveAdopter;

    ListView l1;
    public int id;
    SharedPreferenceManager sharedPrefMgr;
   public String name;
    ArrayList<String> data;
    ArrayList arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_child, container, false);
        bundle = getArguments();
        childname = bundle.getString("data");

        l1=(ListView)view.findViewById(R.id.l1);
        getIDs(view);
        setEvents();
        return view;
    }

    private void getIDs(View view) {

        textViewChildName = (TextView) view.findViewById(R.id.textViewChild);
        textViewChildName.setText(childname);
    }

    private void setEvents() {
        models =new ArrayList<>();

        moveAdopter = new NextAdopter(getActivity(), models);
        l1.setAdapter(moveAdopter);



        Loginpwd();


    }

    protected void Loginpwd() {
        RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(1,
                "http://arkainfoteck.xyz/helpmate/dynamic/index.php/api/products",
                new Response.Listener<String>() {
                    public void onResponse(String response) {

                        String id,name,hours,type,details;
                        try {




                            System.out.println( "Result1:" + response );

                            JSONArray jsonArray1 = new JSONArray( response );
                            System.out.println( "Result aRRAY:" + jsonArray1.toString() );
                            models = new ArrayList<>();


                            for(int i=0;i<jsonArray1.length();i++){
                                JSONObject jsonObject1 = jsonArray1.getJSONObject( i );
                                id=jsonObject1.getString("id");
                                name=jsonObject1.getString("name");

                                System.out.println( "Result object:" + jsonObject1.toString() );

                                String name1 = textViewChildName.getText().toString();


                                if (name.equals( name1 )) {
                                    System.out.println( "Result aft" + data );
                                    System.out.println( "Result id:data2" + name1 );
                                    // childname=bundle.getStringArray( String.valueOf( models ) );
                                    System.out.println( "Result wish: hi" + name.equals( name1 ) );

                                    id=jsonObject1.getString("id");
                                    cardname=jsonObject1.getString("name");
                                    imageUrl=jsonObject1.getString("image");

                                    imageback=jsonObject1.getString("hours");
                                    approvalTime=jsonObject1.getString("type");
                                    annualFee=jsonObject1.getString("details");


                                  /*  cardname = jsonOb122.getString( "CARD_NAME" );
                                    System.out.println( "Result card name:" + cardname.toString() );
                                    imageUrl = jsonOb122.getString( "CARD_IMAGE_1" );
                                    System.out.println( "Result img1:" + imageUrl.toString() );
                                    imageback = jsonOb122.getString( "CARD_IMAGE_2" );
                                    System.out.println( "Result img2:" + imageback.toString() );
                                    webdata = jsonOb122.getString( "ELIGIBILITY" );
                                    System.out.println( "Result eligible:" + webdata.toString() );
                                    approvalTime = jsonOb122.getString( "APPROVAL_TIME" );
                                    System.out.println( "Result eligible:" + approvalTime.toString() );
                                    annualFee = jsonOb122.getString( "ANNUAL_FEES" );
                                    System.out.println( "Result eligible:" + annualFee.toString() );
                                    renewalFee = jsonOb122.getString( "RENEWAL_FEES" );
                                    System.out.println( "Result eligible:" + renewalFee.toString() );*/
                                    //  Toast.makeText( getContext(), "" + cardname + "\n" + imageUrl + "\n" + imageback + "\n" + webdata + "\n" + approvalTime + "\n" + annualFee + "\n" + renewalFee, Toast.LENGTH_LONG ).show();
                                    // models.add( new NextModel(cardname,imageUrl) );
                                    models.add( new NextModel(cardname,imageUrl,imageback,approvalTime,annualFee/*,renewalFee,webdata */) );

                                    //  models.add( new NextModel(cardname,imageUrl,imageback,approvalTime,annualFee,renewalFee,webdata ) );

                                  }
                              }
                            moveAdopter = new NextAdopter( getActivity(), models );
                            l1.setAdapter( moveAdopter );
                            l1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    //Toast.makeText( getActivity(), models.get( position ).getWebvi(), Toast.LENGTH_SHORT ).show();
                                    inin = new Intent( getActivity(), ProductCreditCardBA.class );
                                    inin.putExtra( "cardnaem",models.get( position ).getCardname() );
                                    inin.putExtra( "imgfn", models.get( position ).getImm() );
                                    inin.putExtra( "imgback", models.get( position ).getImgbb() );
                                    inin.putExtra( "approval_time", models.get( position ).getAppTime() );
                                    inin.putExtra( "annual_fee", models.get( position ).getAnualFee() );

                                    startActivity( inin );

                                }
                            } );

/*

                            String statustring = jsonObject1.getString( "status" );
                            System.out.println( "Result status:" + statustring.toString() );

                            if (statustring.equals( "1" )) {
                                String jsonObject2 = jsonObject1.getString( "result" );
                                System.out.println( "Result 2:" + jsonObject2.toString() );
                                JSONArray resobj = new JSONArray( jsonObject2 );

                                models = new ArrayList<>();

                                for (int i = 0; i < resobj.length(); i++) {
                                    JSONObject jsonOb122 = resobj.getJSONObject( i );

                                    String bankId = jsonOb122.getString( "BANK_ID" );
                                    System.out.println( "Result id:" + bankId.toString() );

//                                    String i1 = jsonOb122.getString( "CARD_NAME" );
//                                    System.out.println( "Result card name:" + i1.toString() );

                                    String namebank = jsonOb122.getString( "BANK_NAME" );
                                    System.out.println( "Result card name:" + namebank.toString() );

                                    String name1 = textViewChildName.getText().toString();

                                    if (namebank.equals( name1 )) {
                                        System.out.println( "Result aft" + data );
                                        System.out.println( "Result id:data2" + name1 );
                                        // childname=bundle.getStringArray( String.valueOf( models ) );
                                        System.out.println( "Result wish: hi" + namebank.equals( name1 ) );


                                        cardname = jsonOb122.getString( "CARD_NAME" );
                                        System.out.println( "Result card name:" + cardname.toString() );
                                        imageUrl = jsonOb122.getString( "CARD_IMAGE_1" );
                                        System.out.println( "Result img1:" + imageUrl.toString() );
                                        imageback = jsonOb122.getString( "CARD_IMAGE_2" );
                                        System.out.println( "Result img2:" + imageback.toString() );
                                        webdata = jsonOb122.getString( "ELIGIBILITY" );
                                        System.out.println( "Result eligible:" + webdata.toString() );
                                        approvalTime = jsonOb122.getString( "APPROVAL_TIME" );
                                        System.out.println( "Result eligible:" + approvalTime.toString() );
                                        annualFee = jsonOb122.getString( "ANNUAL_FEES" );
                                        System.out.println( "Result eligible:" + annualFee.toString() );
                                        renewalFee = jsonOb122.getString( "RENEWAL_FEES" );
                                        System.out.println( "Result eligible:" + renewalFee.toString() );
                                      //  Toast.makeText( getContext(), "" + cardname + "\n" + imageUrl + "\n" + imageback + "\n" + webdata + "\n" + approvalTime + "\n" + annualFee + "\n" + renewalFee, Toast.LENGTH_LONG ).show();
                                       // models.add( new NextModel(cardname,imageUrl) );
                                        models.add( new NextModel(cardname,imageUrl,imageback,approvalTime,annualFee,renewalFee,webdata ) );

                                      //  models.add( new NextModel(cardname,imageUrl,imageback,approvalTime,annualFee,renewalFee,webdata ) );

                                    }
                                }
*/

                           /*     moveAdopter = new NextAdopter( getActivity(), models );
                                l1.setAdapter( moveAdopter );
                                l1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        //Toast.makeText( getActivity(), models.get( position ).getWebvi(), Toast.LENGTH_SHORT ).show();
                                        inin = new Intent( getActivity(), ProductCreditCardBA.class );
                                            inin.putExtra( "cardnaem",models.get( position ).getCardname() );
                                            inin.putExtra( "imgfn", models.get( position ).getImm() );
                                            inin.putExtra( "imgback", models.get( position ).getImgbb() );
                                            inin.putExtra( "eligibility", models.get( position ).getWebvi() );
                                            inin.putExtra( "approval_time", models.get( position ).getAppTime() );
                                            inin.putExtra( "annual_fee", models.get( position ).getAnualFee() );
                                            inin.putExtra( "renewal_fee", models.get( position ).getRewlFee() );
                                        startActivity( inin );

                                    }
                                } );*/
                           /* } else {
                                String jsonObject2 = jsonObject1.getString( "message" );
                                System.out.println( "Result 2:" + jsonObject2.toString() );
                                Toast toast5 = Toast.makeText( getActivity(), jsonObject2.toString(), Toast.LENGTH_LONG );
                                toast5.show();

                                System.out.println( "Result Status in false or 0" );
                            }*/


                        } catch (Exception var16) {
                            var16.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError arg0) {



            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap();
                return params;
            }
        };
        rq.add(stringRequest);
    }



}