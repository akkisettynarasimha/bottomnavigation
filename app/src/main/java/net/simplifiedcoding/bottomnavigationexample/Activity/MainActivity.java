package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.simplifiedcoding.bottomnavigationexample.Adapters.ExpandAdapter;
import net.simplifiedcoding.bottomnavigationexample.ExpandableListAdapter;
import net.simplifiedcoding.bottomnavigationexample.Fragments.DashboardFragment;
import net.simplifiedcoding.bottomnavigationexample.Fragments.HomeFragment;
import net.simplifiedcoding.bottomnavigationexample.Fragments.NotificationsFragment;
import net.simplifiedcoding.bottomnavigationexample.Fragments.ProfileFragment;
import net.simplifiedcoding.bottomnavigationexample.Helper.CartSqlite;
import net.simplifiedcoding.bottomnavigationexample.MenuModel;
import net.simplifiedcoding.bottomnavigationexample.Model.Expandlist;
import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//implement the interface OnNavigationItemSelectedListener in your activity class
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ListView listt;
    CartSqlite db;

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
RelativeLayout cart;

    DrawerLayout drawerLayout;
    ArrayList<Expandlist> list;
    ImageView orders_downarrow,orders_uparrow;
TextView charan,count;


    private Handler handler;
    private Runnable handlerTask;

int profile_counts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        db=new CartSqlite(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.relative);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadFragment(new HomeFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
             drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        count = findViewById(R.id.count);


        cart = findViewById(R.id.relativecart);

        db.close();


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        CardView ordercardview=(CardView)findViewById( R.id.ordercard );
        orders_downarrow=findViewById( R.id.orders_downarrow );
        orders_uparrow=findViewById( R.id.orders_upparro );



//listt2.setAdapter(expandAdapter);



        navigation.setOnNavigationItemSelectedListener(this);
        StartTimer();
    }

    void StartTimer(){
        handler = new Handler();
        handlerTask = new Runnable()
        {
            @Override
            public void run() {
                // do something
                profile_counts = db.getProfilesCount();
                count.setText(Integer.toString(profile_counts));
                handler.postDelayed(handlerTask, 1000);
            }
        };
        handlerTask.run();
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel("Beauty & Groming", true, true, ""); //Menu of Java Tutorials
        headerList.add(menuModel);

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("Bothing & Body", false, false, "https://www.journaldev.com/7153/core-java-tutorial");
        childModelsList.add(childModel);

        childModel = new MenuModel("Skin Care", false, false, "https://www.journaldev.com/19187/java-fileinputstream");
        childModelsList.add(childModel);

        childModel = new MenuModel("Hair Care", false, false, "https://www.journaldev.com/19115/java-filereader");
        childModelsList.add(childModel);

        childModel = new MenuModel("Lip Care", false, false, "https://www.journaldev.com/19115/java-filereader");
        childModelsList.add(childModel);
         childModel = new MenuModel("Foot Care", false, false, "https://www.journaldev.com/19115/java-filereader");
        childModelsList.add(childModel);
          childModel = new MenuModel("Eye Care", false, false, "https://www.journaldev.com/19115/java-filereader");
        childModelsList.add(childModel);
          childModel = new MenuModel("Nails Care", false, false, "https://www.journaldev.com/19115/java-filereader");
        childModelsList.add(childModel);
          childModel = new MenuModel("Fragrances ", false, false, "https://www.journaldev.com/19115/java-filereader");
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }

        //childModelsList = new ArrayList<>();
        MenuModel   menuModel1 = new MenuModel("Baby & Kids", true, true, ""); //Menu of Python Tutorials
        headerList.add(menuModel1);



        List<MenuModel> childModelsList1 = new ArrayList<>();
       MenuModel  childModel1 = new MenuModel("Bothing & Baby", false, false, "https://www.journaldev.com/19243/python-ast-abstract-syntax-tree");
        childModelsList1.add(childModel1);
//
        childModel1 = new MenuModel("Baby Oils", false, false, "https://www.journaldev.com/19226/python-fractions");
        childModelsList1.add(childModel1);

        childModel1 = new MenuModel("Baby Diapering", false, false, "https://www.journaldev.com/19226/python-fractions");
        childModelsList1.add(childModel1);

        childModel1 = new MenuModel("Baby Accessories", false, false, "https://www.journaldev.com/19226/python-fractions");
        childModelsList1.add(childModel1);
//
        if (menuModel1.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel1, childModelsList1);
        }
//
        List<MenuModel> childModelsList2 = new ArrayList<>();
       MenuModel menuModel2 = new MenuModel("Travel", true, true, ""); //Menu of Python Tutorials
        headerList.add(menuModel2);
        MenuModel childModel2 = new MenuModel("First Aid ", false, false, "https://www.journaldev.com/19243/python-ast-abstract-syntax-tree");
        childModelsList2.add(childModel2);

        childModel2 = new MenuModel("Pollution Masks", false, false, "https://www.journaldev.com/19226/python-fractions");
        childModelsList2.add(childModel2);

        childModel2 = new MenuModel("Tissues", false, false, "https://www.journaldev.com/19226/python-fractions");
        childModelsList2.add(childModel2);

        if (menuModel2.hasChildren) {
            childList.put(menuModel2, childModelsList2);
        }
    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {

                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (model.url.length() > 0) {
                        Intent intent=new Intent(MainActivity.this,Catogory_DashBoad.class);
                        startActivity(intent);
                    }
                }

                return false;
            }
        });
    }
        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationsFragment();
                break;

            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
