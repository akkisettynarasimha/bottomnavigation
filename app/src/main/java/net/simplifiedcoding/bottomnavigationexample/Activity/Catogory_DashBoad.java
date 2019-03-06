package net.simplifiedcoding.bottomnavigationexample.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import net.simplifiedcoding.bottomnavigationexample.Adapters.ViewPagerAdapter;
import net.simplifiedcoding.bottomnavigationexample.Fragments.Fragment1;
import net.simplifiedcoding.bottomnavigationexample.Fragments.Fragment2;
import net.simplifiedcoding.bottomnavigationexample.Fragments.Fragment3;
import net.simplifiedcoding.bottomnavigationexample.Fragments.Fragment4;
import net.simplifiedcoding.bottomnavigationexample.R;

public class Catogory_DashBoad extends AppCompatActivity {
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    //Fragments

    Fragment2 fragment2;
    Fragment1 fragment1;
    Fragment3 fragment3;
    Fragment4 fragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_catogory__dash_boad);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(4);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragment1=new Fragment1();
        fragment2 =new Fragment2();
        fragment3 =new Fragment3();
        fragment4=new Fragment4();
        adapter.addFragment(fragment1,"FRAGMENT1");
        adapter.addFragment(fragment2,"FRAGMENT2");
        adapter.addFragment(fragment3,"FRAGMENT3");
        adapter.addFragment(fragment4,"FRAGMENT4");
        viewPager.setAdapter(adapter);
    }

    }


