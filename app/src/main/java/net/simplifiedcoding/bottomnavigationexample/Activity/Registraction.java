package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.R;


public class Registraction extends AppCompatActivity {
    FloatingActionButton registractionok;
ImageView image;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraction);
         image=findViewById(R.id.image);
         Picasso.with(this).load(R.drawable.jirvilogo).into(image);
         registractionok=(FloatingActionButton)findViewById(R.id.registractionok);
         registractionok.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 registractionok.setImageResource(R.drawable.ic_arrow_forward_white_24dp);
                 registractionok.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
             //    registractionok.setTag(getResources().getString(R.string.tag_verify));
                 Intent intent=new Intent(Registraction.this,MainActivity.class);
                 startActivity(intent);

             }
         });

    }
}
