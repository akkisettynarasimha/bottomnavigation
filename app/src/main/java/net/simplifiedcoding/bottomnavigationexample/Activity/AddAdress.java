package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import net.simplifiedcoding.bottomnavigationexample.Helper.DatabaseHelper;
import net.simplifiedcoding.bottomnavigationexample.R;

public class AddAdress extends AppCompatActivity {
    LinearLayout submit;
    EditText houseno,roadname,landmark,city,state,pincode;
//    DatabaseHelper databaseHelper;
    String houseno1,roadname1,landmark1,city1,state1,pincode1,rb1;

    RadioGroup radioGroup;
    RadioButton rb;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adress);

        getId();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (houseno.getText().toString().isEmpty() || roadname.getText().toString().isEmpty() || landmark.getText().toString().isEmpty() || city.getText().toString().isEmpty()|| state.getText().toString().isEmpty()|| pincode.getText().toString().isEmpty()||rb.getText().toString().isEmpty() ){

                    Toast.makeText(AddAdress.this, "please fill details", Toast.LENGTH_SHORT).show();
                }else {

                    houseno1=houseno.getText().toString();
                    roadname1=roadname.getText().toString();
                    landmark1=landmark.getText().toString();
                    city1=city.getText().toString();
                    state1=state.getText().toString();
                    pincode1=pincode.getText().toString();
                    rb1=rb.getText().toString();
                    databaseHelper.insertdata(houseno1,roadname1,landmark1,city1,state1,pincode1,rb1);

                    Intent intent = new Intent(AddAdress.this,ChangeAddress.class);
                    startActivity(intent);

                }

            }
        });
    }
    public void getId(){
        houseno=(EditText)findViewById(R.id.houseno);
        roadname=(EditText)findViewById(R.id.roadname);
        landmark=(EditText)findViewById(R.id.landmark);
        city=(EditText)findViewById(R.id.city);
        state=(EditText)findViewById(R.id.state);
        pincode=(EditText)findViewById(R.id.pincode);

        submit = (LinearLayout) findViewById(R.id.submit);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb ) {
                    Toast.makeText(AddAdress.this, rb.getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        // database object
        databaseHelper = new DatabaseHelper(this);

    }



}
