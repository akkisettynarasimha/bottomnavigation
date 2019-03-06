package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.R;


public class Login extends AppCompatActivity {


    ImageView image;
    TextView register,forgot;
FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        image=findViewById(R.id.image);
        register=findViewById(R.id.register);
        forgot=findViewById(R.id.forgot);
      //  Picasso.with(Login.this).load(R.drawable.jirvilogo).into(image);
        floatingActionButton=findViewById(R.id.sendverifybt);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Registraction.class);
                startActivity(intent);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,PhoneNumberVarification.class);
                startActivity(intent);
            }
        });
    }
}
