package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.simplifiedcoding.bottomnavigationexample.Adapters.CartAdapter;
import net.simplifiedcoding.bottomnavigationexample.Helper.CartSqlite;
import net.simplifiedcoding.bottomnavigationexample.Model.Cartmodel;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Location_Activity_with_items extends AppCompatActivity {
    RecyclerView recyclerview;
    CartAdapter cartAdapter;
    List<Cartmodel> cartmodels;
    CartSqlite cartSqlite;
    RelativeLayout empty, show;
    TextView adress;
    GetCurrentLocation currentLoc;
    public String latitude, longitude;
    double l1, l2;
    Geocoder geocoder;
    List<Address> addresses;
    public static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__with_items);
        cartSqlite = new CartSqlite(this);
        show = findViewById(R.id.show);
        empty = findViewById(R.id.empty);
        adress = findViewById(R.id.adress);
        currentLoc = new GetCurrentLocation(Location_Activity_with_items.this);

        ActivityCompat.requestPermissions(Location_Activity_with_items.this, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 100);

        latitude = currentLoc.latitude;
        longitude = currentLoc.longitude;

        if (TextUtils.isEmpty(latitude) || TextUtils.isEmpty(longitude)) {
            latitude = "0.00";
            longitude = "0.00";
        }


        l1 = Double.parseDouble(latitude.toString());
        l2 = Double.parseDouble(longitude.toString());

        geocoder = new Geocoder(Location_Activity_with_items.this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(l1, l2, 1);

            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                result = strReturnedAddress.toString();
                adress.setText(result);
                recyclerview = findViewById(R.id.recyclerview);
                cartmodels = new ArrayList<>();
                recyclerview.setLayoutManager(new LinearLayoutManager(this));
                recyclerview.setHasFixedSize(true);
                Cursor res = cartSqlite.getdata();
                if (res.getCount() == 0) {
                    empty.setVisibility(View.VISIBLE);
                    show.setVisibility(View.GONE);
                    Toast.makeText(this, "cart is empty", Toast.LENGTH_SHORT).show();
                }
                while (res.moveToNext()) {
                    empty.setVisibility(View.GONE);
                    show.setVisibility(View.VISIBLE);
                    cartmodels.add(new Cartmodel(res.getString(0), res.getString(1), res.getString(2), res.getString(3)));
                }
                CartAdapter cartAdapter = new CartAdapter(this, cartmodels);

                recyclerview.setAdapter(cartAdapter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onResume() {
        super.onResume();
        currentLoc.connectGoogleApi();
    }

    @Override
    public void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    };
}
