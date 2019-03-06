package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.R;


public class PhoneNumberVarification extends AppCompatActivity {

    FloatingActionButton fabbutton;
    EditText phoneed;
    LinearLayout phonelinearlayout,linearotp,linearphone;
    TextView text,text1,pleseverify;
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_varification);
        phoneed = (EditText) findViewById(R.id.numbered);
        text=(TextView)findViewById(R.id.text);
        text1=(TextView)findViewById(R.id.text);
        linearotp=(LinearLayout)findViewById(R.id.otp);
        linearphone=(LinearLayout)findViewById(R.id.linearphone);

        pleseverify=(TextView)findViewById(R.id.pleseverify);
        fabbutton = (FloatingActionButton) findViewById(R.id.sendverifybt);
        phonelinearlayout=(LinearLayout)findViewById(R.id.phonelinearlayout);
        image=findViewById(R.id.image);
        Picasso.with(this).load(R.drawable.jirvilogo).into(image);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/MyriadPro_Bold.otf");

        phoneed.setTypeface(type);
        pleseverify.setTypeface(type);

        phoneed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonelinearlayout.setBackgroundResource(R.drawable.edittextshape);
            }
        });
        fabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fabbutton.getTag().equals(getResources().getString(R.string.tag_send))) {
                    if (!phoneed.getText().toString().trim().isEmpty() && phoneed.getText().toString().trim().length() >= 10) {
                       /* linearphone.setVisibility(View.INVISIBLE);
                        linearotp.setVisibility(View.VISIBLE);
                        fabbutton.setImageResource(R.drawable.ic_arrow_forward_white_24dp);
                       */ fabbutton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                        fabbutton.setTag(getResources().getString(R.string.tag_verify));
                        Intent intent=new Intent(PhoneNumberVarification.this,PhoneNumberVarifiactionDetails.class);
                        startActivity(intent);
                    } else {
                        phoneed.setError("Please enter valid mobile number");

                    }
                }else {
                    Snackbar snackbar = Snackbar
                            .make((CoordinatorLayout) findViewById(R.id.parentlayout), "Please wait...", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }





            }
        });
    }
}
