package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.simplifiedcoding.bottomnavigationexample.NextModel;
import net.simplifiedcoding.bottomnavigationexample.R;
import net.simplifiedcoding.bottomnavigationexample.creditcardproductsba.FragmentParent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActSubCatogory extends AppCompatActivity {

    FragmentParent fragmentParent;

    private ArrayList<SubCatogoryHeader> models;
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
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "http://www.jirvi.com/restapi/leftmenu.php?catid=4",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            String id,name;
JSONObject C=new JSONObject(response);

                            JSONArray jsonArray = C.getJSONArray( "categories" );

                            Toast.makeText(ActSubCatogory.this, ""+jsonArray, Toast.LENGTH_SHORT).show();
                            models =new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                id=jsonObject.getString("id");
                                name=jsonObject.getString("name");
                                SubCatogoryHeader nextModel = new SubCatogoryHeader(name);
                                fragmentParent.addPage( name+"" );
                                // fragmentParent.addPage( i1 );
                                models.add(i, nextModel);
                                System.out.println("Result"+models.size());
                                System.out.print( "Request object:" +jsonObject.toString() );

                            }

/*


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
