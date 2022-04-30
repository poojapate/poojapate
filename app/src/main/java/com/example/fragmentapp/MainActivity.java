package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        tab = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        tab.setupWithViewPager(pager);
        pager.setAdapter(pagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.tv:
                Toast.makeText(this, "tv", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.linked:
                Toast.makeText(this, "linked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.starred:
                Toast.makeText(this, "starred", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.payment:
                Toast.makeText(this, "payment", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Intent intent3= new Intent(MainActivity.this,SetActivity.class);
                startActivity(intent3);
                return true;
            case R.id.home:
                Intent intent2= new Intent(MainActivity.this,ContectActivity.class);
                startActivity(intent2);
                return true;

                case R.id.Search:
                Intent intent= new Intent(MainActivity.this,searchActivity2.class);
                startActivity(intent);
                    return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}


