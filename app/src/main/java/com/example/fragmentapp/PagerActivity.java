package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class PagerActivity extends AppCompatActivity {


    Toolbar toolbar;
    TabLayout Tab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        toolbar=findViewById(R.id.toolbar);
        Tab=findViewById(R.id.Tab);
        pager=findViewById(R.id.pager);

        ViewpagerAdapter viewpagerAdapter=new ViewpagerAdapter(getSupportFragmentManager());
        Tab.setupWithViewPager(pager);
        pager.setAdapter(viewpagerAdapter);


    }
}