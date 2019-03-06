package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.simplifiedcoding.bottomnavigationexample.R;


public class PhoneNumberVarifiactionDetails extends AppCompatActivity {

    FloatingActionButton varifyotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_varifiaction_details);

        varifyotp=(FloatingActionButton)findViewById(R.id.varifyotp);
        varifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(PhoneNumberVarifiactionDetails.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
