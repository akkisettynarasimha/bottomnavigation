package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.simplifiedcoding.bottomnavigationexample.R;

public class ProductAdrress extends AppCompatActivity {

    Button changeaddress,continuee;
    SharedPreferences sharedPreferences;
    String name;
    TextView address_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_adrress);
        changeaddress=(Button)findViewById(R.id.changeaddress);
        continuee=(Button)findViewById(R.id.continuee);
        address_details=(TextView)findViewById(R.id.address_details);
        changeaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductAdrress.this,ChangeAddress.class);
                startActivity(intent);
            }
        });

        sharedPreferences=getSharedPreferences("AddressDetails", Context.MODE_PRIVATE);
        name=sharedPreferences.getString("completeaddress",null);

        // continue button click
        continuee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductAdrress.this,PaymentActivity.class);
                startActivity(intent);
            }
        });

        address_details.setText(""+address_details);
    }
}
