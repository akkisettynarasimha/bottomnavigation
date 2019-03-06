package net.simplifiedcoding.bottomnavigationexample.creditcardproductsba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.simplifiedcoding.bottomnavigationexample.NextModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreditCardBankNamesBA extends AppCompatActivity {
    FragmentParent fragmentParent;

    private ArrayList<NextModel> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_credit_card_bank_names_b );
        getIDs();
        setEvents();
        DynamicFragment();
    }

    private void getIDs() {
        fragmentParent = (FragmentParent) this.getSupportFragmentManager().findFragmentById(R.id.fragmentParent);
    }

    private void setEvents() {

    }

    protected void DynamicFragment(){
        RequestQueue rq = Volley.newRequestQueue( getApplicationContext() );
        StringRequest stringRequest = new StringRequest( 1,
                "http://arkainfoteck.xyz/helpmate/dynamic/index.php/api/products",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String id,name;
                            System.out.print( "Request1:" +response );

                            JSONArray jsonArray = new JSONArray( response );
                            System.out.print( "Request Array:" +jsonArray );
                            models =new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                 id=jsonObject.getString("id");
                                 name=jsonObject.getString("name");
                                NextModel nextModel = new NextModel(name);
                                fragmentParent.addPage( name+"" );
                                // fragmentParent.addPage( i1 );
                                models.add(i, nextModel);

                                System.out.println("Result"+models.size());
                                System.out.print( "Request object:" +jsonObject.toString() );

                            }

/*

                            String statustring = jsonObject.getString("status");
                            System.out.println("Result status:"+statustring.toString());

                            if (statustring.equals("1")) {
                                String jsonObject2=jsonObject.getString("result");
                                System.out.println("Result 2:"+jsonObject2.toString());
                                JSONArray resobj = new JSONArray(jsonObject2);

                                models =new ArrayList<>();
                                for(int i=0;i<resobj.length();i++) {
                                    JSONObject jsonOb122 = resobj.getJSONObject(i);

                                    String bankid= jsonOb122.getString("BANK_ID");
                                    System.out.println("Result id:" + bankid.toString());



                                    String i1= jsonOb122.getString("BANK_NAME");
                                    System.out.println("Result id:" + i1.toString());

                                    NextModel nextModel = new NextModel(i1);
                                    fragmentParent.addPage( i1+"" );
                                  // fragmentParent.addPage( i1 );
                                    models.add(i, nextModel);

                                    System.out.println("Result"+models.size());

                                }

                            } else {
                                String jsonObject2=jsonObject.getString("message");
                                System.out.println("Result 2:"+jsonObject2.toString());
                                Toast toast5 = Toast.makeText(getApplicationContext(), jsonObject2.toString(), Toast.LENGTH_LONG);
                                toast5.show();
                                //pd.hide();
                                System.out.println("Result Status in false or 0");
                            }
*/

                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } ) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap(  );
                return params;
            }
        };
        rq.add( stringRequest );
    }
}
