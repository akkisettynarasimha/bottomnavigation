package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.simplifiedcoding.bottomnavigationexample.Adapters.CartAdapter;
import net.simplifiedcoding.bottomnavigationexample.Helper.CartSqlite;
import net.simplifiedcoding.bottomnavigationexample.Model.Cartmodel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class CartActivity extends AppCompatActivity {
RecyclerView recyclerview;
CartAdapter cartAdapter;
List<Cartmodel> cartmodels;
CartSqlite cartSqlite;
RelativeLayout empty,show;
Button continuee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartSqlite=new CartSqlite(this);
        show=findViewById(R.id.show);
        empty=findViewById(R.id.empty);
        recyclerview=findViewById(R.id.recyclerview);
        continuee=findViewById(R.id.continuee);
        continuee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CartActivity.this,ProductAdrress.class);
                startActivity(intent);
            }
        });
        cartmodels=new ArrayList<>();
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);

        Cursor res=cartSqlite.getdata();

        if (res.getCount()==0)
        {
            empty.setVisibility(View.VISIBLE);
            show.setVisibility(View.GONE);
            Toast.makeText(this, "cart is empty", Toast.LENGTH_SHORT).show();
        }
        while (res.moveToNext())
        {
            empty.setVisibility(View.GONE);
            show.setVisibility(View.VISIBLE);
            cartmodels.add(new Cartmodel(res.getString(0),res.getString(1),res.getString(2),res.getString(3)));
        }
CartAdapter cartAdapter=new CartAdapter(this,cartmodels);

        recyclerview.setAdapter(cartAdapter);
    }
}
