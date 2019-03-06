package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.Adapters.ProductDiscreptionAdopter;
import net.simplifiedcoding.bottomnavigationexample.Helper.CartSqlite;
import net.simplifiedcoding.bottomnavigationexample.Model.ProductDiscreptionModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ProductDiscreption extends AppCompatActivity {
    CartSqlite cartSqlite;
    RecyclerView recyclerView;
Button addtocart,buy;
    public ProductDiscreptionAdopter productDiscreptionAdopter;
    ArrayList<ProductDiscreptionModel> productDiscreptionModels;
    LinearLayoutManager gridLayoutManager;
    TextView pdt1name,pdt3cost;
    ImageView productimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_discreption);
        cartSqlite=new CartSqlite(this);
pdt1name=findViewById(R.id.pdt1);
        productimage=findViewById(R.id.productimage);
Picasso.with(this).load(R.drawable.grepthor).into(productimage);
pdt3cost=findViewById(R.id.pdt3);
        addtocart=findViewById(R.id.addtocart);
        buy=findViewById(R.id.buy);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean resultt=cartSqlite.insertdata(pdt1name.getText().toString(),pdt3cost.getText().toString(), String.valueOf(productimage),"1");

                if (resultt==true)
                {
                    Toast.makeText(ProductDiscreption.this, "added successfull", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ProductDiscreption.this, "not added ", Toast.LENGTH_SHORT).show();
                }
            }
        });




        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean resultt=cartSqlite.insertdata(pdt1name.getText().toString(),pdt3cost.getText().toString(), String.valueOf(R.drawable.grepthor),"1");

                if (resultt==true)
                {


                    Intent intent=new Intent(ProductDiscreption.this,ProductAdrress.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(ProductDiscreption.this, "not added ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.productcontant);
        recyclerView.setHasFixedSize(true);
        gridLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        productDiscreptionModels=new ArrayList<>();
        productDiscreptionModels.add(new ProductDiscreptionModel("Color","white"));
        productDiscreptionModels.add(new ProductDiscreptionModel("Size","XL"));
        productDiscreptionModels.add(new ProductDiscreptionModel("Offer","30%"));
        productDiscreptionModels.add(new ProductDiscreptionModel("Order","2/2/2019"));
        productDiscreptionModels.add(new ProductDiscreptionModel("Details","best for you"));

        productDiscreptionAdopter=new ProductDiscreptionAdopter(getApplicationContext(),productDiscreptionModels);
        recyclerView.setAdapter(productDiscreptionAdopter);
    }
}
