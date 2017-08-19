package com.example.handa.fjunction2;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class Tabupload extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //This is our tablayout
    private TabLayout tabLayout1;

    //This is our viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabselect);
        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout1 = (TabLayout) findViewById(R.id.tabLayout);

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tabupload, container, false);
        Toolbar toolbar

        //Adding toolbar to the activity
           = (Toolbar) view.findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);
        //for crate home button
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initializing the tablayout
        tabLayout1 = (TabLayout) view.findViewById(R.id.tabLayout2);
*/
        //Adding the tabs using addTab() method
        tabLayout1.addTab(tabLayout1.newTab().setIcon(R.drawable.gallary));
        tabLayout1.addTab(tabLayout1.newTab().setIcon(R.drawable.cameraa));
        tabLayout1.addTab(tabLayout1.newTab().setIcon(R.drawable.videoaa));


        // tabLayout.setBackgroundColor(Color.RED);
        tabLayout1.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#f24a47"), PorterDuff.Mode.SRC_IN);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);

        /*
        final TabBarupload adapter = new TabBarupload
                (activity.getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager.setAdapter(adapter);

        //page change listener swiping
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.setOnTabSelectedListener(this);
*/
        final TabBarupload adapter = new TabBarupload
                (getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager.setAdapter(adapter);

        //page change listener swiping
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.setOnTabSelectedListener(this);
    }






    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(Color.parseColor("#f24a47"), PorterDuff.Mode.SRC_IN);
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(Color.parseColor("#f24a47"), PorterDuff.Mode.SRC_IN);

    }


}

