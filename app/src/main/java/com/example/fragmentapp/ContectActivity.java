package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContectActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView Contect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contect);

        back=findViewById(R.id.back);
        Contect=findViewById(R.id.Contect);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ContectActivity.this, RecyclerView.VERTICAL,false);
        Contect.setLayoutManager(linearLayoutManager);

       ContectAdapter contectAdapter =new ContectAdapter(ContectActivity.this);
        Contect.setAdapter(contectAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }



        });
    }

}