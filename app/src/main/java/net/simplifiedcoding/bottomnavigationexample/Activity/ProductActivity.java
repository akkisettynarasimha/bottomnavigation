package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;



import net.simplifiedcoding.bottomnavigationexample.Adapters.ProductAdopter;
import net.simplifiedcoding.bottomnavigationexample.Model.ProductModel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ProductAdopter productAdopter;
    ArrayList<ProductModel> productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        recyclerView=(RecyclerView)findViewById(R.id.product);
        gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        productModel=new ArrayList();
        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));

        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));

        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));

        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));

        productModel.add(new ProductModel("name"));
        productModel.add(new ProductModel("name"));


        productAdopter=new ProductAdopter(this,productModel);
        recyclerView.setAdapter(productAdopter);
    }
}
